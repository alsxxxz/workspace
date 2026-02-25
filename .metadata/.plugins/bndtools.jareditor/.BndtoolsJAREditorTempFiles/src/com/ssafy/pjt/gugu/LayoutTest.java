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

        // END
    }

    private void makeProblemPanel() {
        // TODO: 문제를 출제할 패널을 구성하시오.

        // END
    }

    private void updateStatusLabel(JLabel label) {
        int newText = Integer.parseInt(label.getText()) + 1;
        label.setText(newText + "");
    }

    public static void main(String[] args) {
        LayoutTest lt = new LayoutTest();
        lt.launchUi();
    }

}
