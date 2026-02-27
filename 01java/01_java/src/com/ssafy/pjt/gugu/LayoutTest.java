 package com.ssafy.pjt.gugu;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ssafy.pjt.gugu.dto.Problem;
import com.ssafy.pjt.gugu.service.ProblemService;

@SuppressWarnings("serial")
public class LayoutTest extends JFrame {
    private ProblemService service = ProblemService.getService();

    private JLabel lNum1, lNum2, lCorrectCnt, lWrongCnt;
    private JTextField tfAns;
    private Problem problem;

    private void launchUi() {
        this.add(new JLabel("구구단을 외자!"), BorderLayout.NORTH);

        makeProblemPanel();
        makeResultPanel();
        // Frame 기본 설정
        this.setTitle("layout test");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void makeProblem() {
        problem = service.makeProblem();
        lNum1.setText(problem.num1() + "");
        lNum2.setText(problem.num2() + "");
        tfAns.setText("");
    }

    private void makeResultPanel() {
        // TODO: 결과를 보여줄 panel을 구성하시오.
        JPanel panel = new JPanel();
        panel.add(new JLabel(" 점검 개수: "));
        lCorrectCnt = new JLabel("0");
        lWrongCnt = new JLabel("0");
        panel.add(lCorrectCnt);
        panel.add(new JLabel(" 오답 개수: "));
        panel.add(lWrongCnt);
        this.add(panel, BorderLayout.SOUTH);
        // END
    }

    private void makeProblemPanel() {
        // TODO: 문제를 보여줄 panel을 구성하시오.
        JPanel panel = new JPanel();
        lNum1 = new JLabel();
        lNum2 = new JLabel();
        tfAns = new JTextField();
        
        
        
        tfAns.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
        			String input = tfAns.getText();
        			try {
        				int num = Integer.parseInt(input);
        				boolean result = service.isCorrect(problem, num);
        				updateStatusLabel(result? lCorrectCnt: lWrongCnt);
        			}catch(Exception ex) {
        				updateStatusLabel(lWrongCnt);
        				ex.printStackTrace();
        			}finally {
        				makeProblem();
        			}
        			System.out.println("엔터");
        		}
        	}
        }
        );
        
        panel.add(lNum1);
        panel.add(new JLabel(" * "));
        panel.add(lNum2);
        panel.add(new JLabel(" * "));
        panel.add(tfAns);
        this.add(panel, BorderLayout.CENTER);
        makeProblem();
        
        
    }
    // END
    


    private void updateStatusLabel(JLabel label) {
        int newText = Integer.parseInt(label.getText()) + 1;
        label.setText(newText + "");
    }

    public static void main(String[] args) {
        LayoutTest lt = new LayoutTest();
        lt.launchUi();
    }

}
