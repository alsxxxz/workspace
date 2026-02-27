
import java.net.*;
import java.io.*;
import java.util.*;

class Point {

    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vector vectorTo(Point dst) {
        return new Vector(x, y, dst.x - x, dst.y - y);
    }

    double distTo(Vector vec) {
        // TODO
        return 0;
    }
}

/**
 * 시작 점(x, y)으로 부터 어떤 곳으로 도달하기 위한 벡터(dx, dy)를 담는 클래스.
 */
class Vector extends Point {

    double dx;
    double dy;

    Vector(double x, double y, double dx, double dy) {
        super(x, y);
        this.dx = dx;
        this.dy = dy;
    }

    double getRadian() {
        return Math.atan2(dy, dx);
    }

    double getDistance() {
        return Math.hypot(dx, dy);
    }
}

/**
 * 일타싸피 당구공을 나타내는 클래스.
 */
class Ball extends Point {

    double r = 5.73 / 2;
    int number;

    Ball(double x, double y, int number) {
        super(x, y);
        this.number = number;
    }

    boolean isInHole() {
        return x == -1 && y == -1;
    }

    boolean isWhiteBall() {
        return number == 0;
    }

    boolean isEightBall() {
        return number == 5;
    }

    boolean isMyBall(int order) {
        return (order == 1)
                ? (number == 1 || number == 3 || number == 5)
                : (number == 2 || number == 4 || number == 5);
    }

    /**
     * 다른 공으로 이 공을 dst 위치로 보내려면, 다른 공을 어느 좌표로 보내야하는지 반환.
     *
     * @param dst 이 공을 보내고 싶은 위치.
     * @return
     */
    Point pointToHit(Point dst) {
        double rad = vectorTo(dst).getRadian();
        double dist = 2.0 * r;
        return new Point(x - dist * Math.cos(rad), y - dist * Math.sin(rad));
    }

    /**
     * 공이 나아갈 직선 상에 다른 공이 있는지 여부를 체그하는 메서드가 필요함
     */
    boolean isBlockedBy(Point dest, Ball otherBall) {
        Vector vec = this.vectorTo(dest);

        // this 공에서 otherBall까지의 벡터 성분
        double ox = otherBall.x - this.x;
        double oy = otherBall.y - this.y;

        // 진행 직선과 otherBall 중심 사이의 수직 거리 (외적 / 벡터 크기)
        double cross = vec.dx * oy - vec.dy * ox;
        double dist = Math.abs(cross) / vec.getDistance();

        // 두 공의 반지름 합보다 거리가 크면 막히지 않음
        if (dist >= 2 * r) {
            return false;
        }

        // otherBall이 this와 dest 사이 구간에 있는지 내적으로 확인
        double dot = vec.dx * ox + vec.dy * oy;
        double vecLenSq = vec.dx * vec.dx + vec.dy * vec.dy;

        return dot > 0 && dot < vecLenSq;
    }

    /**
     * (Deprecated) 쿠션으로 치지 않는 한, 원하는 지점으로 날려버리기 어려운 공인지 여부. (나의 풀이는 쿠션을 고려하지
     * 않으므로 이러한 경우를 기피해야 한다.)
     *
     * @param dest 어디로 날려 보낼지.
     * @param whiteBall
     * @return
     */
    boolean isPointToHitHardToReach(Point dest, Ball whiteBall) {
        double distToCenter = whiteBall.vectorTo(this).getDistance();
        double distToHit = whiteBall.vectorTo(this.pointToHit(dest)).getDistance();
        return distToCenter <= (distToHit + r / 2);
    }

    @Override
    public String toString() {
        return String.format("<Ball x=%f y=%f>", x, y);
    }
}

class Shot implements Comparable<Shot> {

    double radian;
    double power;
    double cosine;

    Shot(double radian, double power, double cosine) {
        this.radian = radian;
        this.power = power;
        this.cosine = cosine;
    }

    float getPower() {
        return (float) this.power;
    }

    float getAngle() {
        return (float) Math.toDegrees(radian);
    }

    /**
     * 라디안으로 계산해둔 샷의 각도를 180도법으로 변환. (단, 여러 시행착오를 통해 알아낸 방법을 통해) x축 양의 방향이 0도가
     * 되도록 조정함. 반시계 방향으로 돌리면 각도가 커지는 방법.
     *
     * @return
     */
    float getFixedAngle() {
        float degrees = getAngle();
        return (360 - (degrees - 90)) % 360;
        // return 0; // TOP
        // return 90; // RIGHT
        // return 180; // Bottom
        // return (float) (((180.0 / Math.PI) * radian) + 90);
    }

    @Override
    public int compareTo(Shot other) {
        return Double.compare(cosine, other.cosine);
    }
}

class Game {

    static final float TABLE_WIDTH = 254;
    static final float TABLE_HEIGHT = 127;

    static final int NUMBER_OF_BALLS = 6;

    // 가이드에 적힌대로 홀 좌표들에 3정도의 오차를 적용해주었습니다.
    static final Point[] HOLES = {
        new Point(-3, -3),
        new Point(TABLE_WIDTH / 2, -3),
        new Point(TABLE_WIDTH + 3, -3),
        new Point(-3, TABLE_HEIGHT + 3),
        new Point(TABLE_WIDTH / 2, TABLE_HEIGHT + 3),
        new Point(TABLE_WIDTH + 3, TABLE_HEIGHT + 3)
    };

    int order;
    Ball[] balls = new Ball[NUMBER_OF_BALLS];

    Ball getWhiteBall() {
        return balls[0];
    }

    Ball getEightBall() {
        return balls[5];
    }

    void update(float[][] balls, int order) {
        this.order = order;
        for (int i = 0; i < NUMBER_OF_BALLS; i++) {
            this.balls[i] = new Ball(balls[i][0], balls[i][1], i);
        }
    }

    Shot getShot() {
        List<Shot> shots = new ArrayList<>();
        if (shouldHitEightBall()) {
            shots.addAll(makeShotCandidates(getEightBall()));
        } else {
            for (Ball ball : balls) {
                if (ball.isMyBall(order) && !ball.isInHole() && !ball.isEightBall()) {
                    shots.addAll(makeShotCandidates(ball));
                }
            }
        }
        shots.sort(Comparator.reverseOrder());
        return shots.get(0);
    }

    boolean shouldHitEightBall() {
        for (Ball ball : balls) {
            if (ball.isMyBall(order) && !ball.isInHole() && !ball.isEightBall()) {
                return false;
            }
        }
        return true;
    }

    List<Shot> makeShotCandidates(Ball myBall) {
        List<Shot> shots = new ArrayList<>();

        // 어떤 홀에 넣는게 좋을까?
        for (Point hole : HOLES) {
            Vector toBall = getWhiteBall().vectorTo(myBall.pointToHit(hole));
            Vector toHole = myBall.vectorTo(hole);

            // 1에 가까울 수록 직선임.
            double cosineSimilarity = Math.cos(toHole.getRadian() - toBall.getRadian());

            shots.add(new Shot(toBall.getRadian(), makePower(toBall.getDistance()), cosineSimilarity));
        }
        return shots;
    }

    double makePower(double dist) {
        double maxDist = Math.hypot(TABLE_WIDTH, TABLE_HEIGHT);

        // 짧은 거리일 땐 많이 낮게, 먼 거리이면 더 높게, 마치 로그 함수 같은 속도 곡선을 구현함.
        return 100 * 1 / Math.exp(1 - (dist / maxDist));
    }
}

public class A0008_1542122 {

    // 닉네임을 사용자에 맞게 변경해 주세요.
    static final String NICKNAME = "박민주";

    // 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
    static final String HOST = "127.0.0.1";

    // 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
    static final int PORT = 1447;
    static final int CODE_SEND = 9901;
    static final int CODE_REQUEST = 9902;
    static final int SIGNAL_ORDER = 9908;
    static final int SIGNAL_CLOSE = 9909;

    // 게임 환경에 대한 상수입니다.
    static final int TABLE_WIDTH = 254;
    static final int TABLE_HEIGHT = 127;
    static final int NUMBER_OF_BALLS = 6;
    static final int[][] HOLES = {{0, 0}, {127, 0}, {254, 0}, {0, 127}, {127, 127}, {254, 127}};

    static float[][] balls = new float[NUMBER_OF_BALLS][2];
    static int order = 0;
    static float angle = 0;
    static float power = 0;

    public static void main(String[] args) {

        Socket socket = null;
        String recv_data = null;
        byte[] bytes = new byte[1024];
        Game game = new Game();

        try {
            socket = new Socket();
            System.out.println("Trying Connect: " + HOST + ":" + PORT);
            socket.connect(new InetSocketAddress(HOST, PORT));
            System.out.println("Connected: " + HOST + ":" + PORT);

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            String send_data = CODE_SEND + "/" + NICKNAME + "/";
            bytes = send_data.getBytes("UTF-8");
            os.write(bytes);
            os.flush();
            System.out.println("Ready to play!\n--------------------");

            while (socket != null) {

                // Receive Data
                bytes = new byte[1024];
                int count_byte = is.read(bytes);
                recv_data = new String(bytes, 0, count_byte, "UTF-8");
                System.out.println("Data Received: " + recv_data);

                // Read Game Data
                String[] split_data = recv_data.split("/");
                int idx = 0;
                try {
                    for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                        for (int j = 0; j < 2; j++) {
                            balls[i][j] = Float.parseFloat(split_data[idx++]);
                        }
                    }
                } catch (Exception e) {
                    bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
                    os.write(bytes);
                    os.flush();
                    System.out.println("Received Data has been currupted, Resend Requested.");
                    continue;
                }

                // Check Signal for Player Order or Close Connection
                if (balls[0][0] == SIGNAL_ORDER) {
                    order = (int) balls[0][1];
                    System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
                    continue;
                } else if (balls[0][0] == SIGNAL_CLOSE) {
                    break;
                }

                // Show Balls' Position
                for (int i = 0; i < NUMBER_OF_BALLS; i++) {
                    System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
                }

                //////////////////////////////
                // 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
                //
                // 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
                // - order: 1인 경우 선공, 2인 경우 후공을 의미
                // - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
                // 예) balls[0][0]: 흰 공의 X좌표
                // balls[0][1]: 흰 공의 Y좌표
                // balls[1][0]: 1번 공의 X좌표
                // balls[4][0]: 4번 공의 X좌표
                // balls[5][0]: 마지막 번호(8번) 공의 X좌표

                // 여기서부터 코드를 작성하세요.
                // 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

                game.update(balls, order);
                Shot shot = game.getShot();

                System.out.printf("Internal Angle in Degrees: %f\n", shot.getAngle());

                angle = shot.getFixedAngle();
                power = shot.getPower();

                // 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
                // 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
                // - angle: 흰 공을 때려서 보낼 방향(각도)
                // - power: 흰 공을 때릴 힘의 세기
                //
                // 이 때 주의할 점은 power는 100을 초과할 수 없으며,
                // power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
                //
                // 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
                //////////////////////////////

                String merged_data = angle + "/" + power + "/";
                bytes = merged_data.getBytes("UTF-8");
                os.write(bytes);
                os.flush();
                System.out.println("Data Sent: " + merged_data);
            }

            os.close();
            is.close();
            socket.close();
            System.out.println("Connection Closed.\n--------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
