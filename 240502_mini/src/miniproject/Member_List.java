package miniproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Member_List extends JFrame implements MouseListener, ActionListener {

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
	JButton randomButton;

	public Member_List() {
		super("회원관리 프로그램  v0.1.1");
		MemberDAO dao = new MemberDAO();
		v = dao.getMemberList();
		cols = getColumn();
		model = new DefaultTableModel(v, cols);

		jTable = new JTable(model);
		pane = new JScrollPane(jTable);
		add(pane);

		pbtn = new JPanel();
		btnInsert = new JButton("회원가입");
		dayNightButton = new JButton("Day");
		randomButton = new JButton("Random"); 

		pbtn.add(btnInsert);
		pbtn.add(dayNightButton);
		pbtn.add(randomButton); 

		add(pbtn, BorderLayout.NORTH);

		jTable.addMouseListener(this);
		
		btnInsert.addActionListener(this);
		dayNightButton.addActionListener(this);
		randomButton.addActionListener(this); 

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
		getContentPane().setBackground(Color.BLACK);
		MemberDAO dao = new MemberDAO();
		DefaultTableModel model = new DefaultTableModel(dao.getMemberList(), getColumn());
		jTable.setModel(model);
		
	}

	public static void main(String[] args) {
		new Member_List();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int r = jTable.getSelectedRow();
		System.out.println("클릭시 클릭된 행번호 확인: " + r);
		String id = (String) jTable.getValueAt(r, 0);
		System.out.println("클릭시 클릭된 선택된 id 조회: " + id);
		MemberProc mem = new MemberProc(id, this);
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
		if (e.getSource() == btnInsert) {
			new MemberProc(this);
		} else if (e.getSource() == dayNightButton) {
			if (dayNightButton.getText().equals("Day")) {
				setDayMode();
			} else {
				setNightMode();
			}
		} else if (e.getSource() == randomButton) {
			setRandomBackgroundColor(); 
		}

	}

	private void setDayMode() {
		getContentPane().setBackground(Color.WHITE);
		pbtn.setBackground(Color.WHITE);
		jTable.setBackground(Color.WHITE);
		jTable.setForeground(Color.BLACK);
		dayNightButton.setText("Night");
		pane.setBackground(Color.WHITE);
		pane.setForeground(Color.BLACK);
		
	}

	private void setNightMode() {
		getContentPane().setBackground(Color.BLACK);
		pbtn.setBackground(Color.BLACK);
		jTable.setBackground(Color.BLACK);
		jTable.setForeground(Color.WHITE);
		pane.setBackground(Color.BLACK);
		pane.setBackground(Color.WHITE);
		dayNightButton.setText("Day");
		
	}

	private void setRandomBackgroundColor() {
		Random rand = new Random();
		int red = rand.nextInt(256);
		int green = rand.nextInt(256);
		int blue = rand.nextInt(256);
		Color randomColor = new Color(red, green, blue);
		getContentPane().setBackground(randomColor);
		jTable.setBackground(new Color(red, green, blue));
		jTable.setForeground(Color.BLACK);
		pbtn.setBackground(new Color(red, green, blue));
		pane.setBackground(new Color(red, green, blue));
		pane.setForeground(Color.BLACK);
		
	}
}
