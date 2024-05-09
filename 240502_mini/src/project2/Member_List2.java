package project2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import miniproject.MemberProc;

public class Member_List2 extends JFrame implements MouseListener, ActionListener {

	Vector v;
	Vector cols;
	DefaultTableModel model;
	JTable jTable;
	JScrollPane pane;
	JPanel pbtn;
	JButton btnInsert;
	JLabel lblUsername;
	JLabel lblPassword;
	JButton dayNightButton;

	// 생성자
	public Member_List2() {
		super("회원관리 프로그램  v0.1.1");
		MemberDAO2 dao = new MemberDAO2();
		v = dao.getMemberList();
		cols = getColumn();
		model = new DefaultTableModel(v, cols);

		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		pbtn = new JPanel();
		btnInsert = new JButton("회원가입");
		pbtn.add(btnInsert);
		dayNightButton = new JButton("Day");
		dayNightButton.addActionListener(this);
		pbtn.add(dayNightButton); 
		add(pbtn, BorderLayout.NORTH);

		jTable.addMouseListener(this);
		btnInsert.addActionListener(this);

		setSize(600, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Vector getColumn() {
		Vector col = new Vector();
		col.add("아이디");
		col.add("비밀번호");
		col.add("이름");
		col.add("전화");
		col.add("주소");
		col.add("생일");
		col.add("직업");
		col.add("성별");
		col.add("이메일");
		col.add("자기소개");

		return col;
	}

	public void jTableRefresh() {
		MemberDAO2 dao = new MemberDAO2();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());
		jTable.setModel(model);
	}

	public static void main(String[] args) {
		new Member_List2();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable.getSelectedRow();
		System.out.println("클릭시 클릭된 행번호 확인: " + r);
		String id = (String) jTable.getValueAt(r, 0);
		System.out.println("클릭시 클릭된 선택된 id 조회: " + id);
		MemberProc2 mem = new MemberProc2(id, this);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
    public void actionPerformed(ActionEvent e) {
        // dayNightButton 클릭 시
        if (e.getSource() == dayNightButton) {
            // 현재 버튼의 텍스트가 "Day"인 경우
            if (dayNightButton.getText().equals("Day")) {
                setDayMode(); // Day 모드 설정
            } else {
                setNightMode(); // Night 모드 설정
            }
        } else if (e.getSource() == btnInsert) {
            new MemberProc2(this);
        }
    }

	

	private void setDayMode() {
		getContentPane().setBackground(Color.WHITE);
		pbtn.setBackground(Color.WHITE);
		btnInsert.setBackground(Color.WHITE);
		btnInsert.setForeground(Color.BLACK);
		jTable.setBackground(Color.WHITE);
		jTable.setForeground(Color.BLACK);
		dayNightButton.setText("Night");
		dayNightButton.setForeground(Color.BLACK);

		// 이름과 비밀번호 입력란 배경색 및 텍스트 색상 변경
		lblUsername.setBackground(Color.WHITE);
		lblUsername.setForeground(Color.BLACK);
		lblPassword.setBackground(Color.WHITE);
		lblPassword.setForeground(Color.BLACK);
	}

	private void setNightMode() {
		getContentPane().setBackground(Color.BLACK);
		pbtn.setBackground(Color.BLACK);
		btnInsert.setBackground(Color.BLACK);
		btnInsert.setForeground(Color.WHITE);
		jTable.setBackground(Color.BLACK);
		jTable.setForeground(Color.WHITE);
		dayNightButton.setText("Day");
		dayNightButton.setForeground(Color.WHITE);

		// 이름과 비밀번호 입력란 배경색 및 텍스트 색상 변경
		lblUsername.setBackground(Color.BLACK);
		lblUsername.setForeground(Color.WHITE);
		lblPassword.setBackground(Color.BLACK);
		lblPassword.setForeground(Color.WHITE);
	}
}
