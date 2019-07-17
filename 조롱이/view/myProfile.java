package seontalk.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import seontalk.vo.MemberVO;
 

public class myProfile extends JFrame {
		
	
	
		JPanel jp_north = new JPanel();
		JPanel jp_south = new JPanel();
		
		//////////프로필 선언부////////////////////////////
        
        JPanel jp_profile = new JPanel();
        JLabel jl_post = new JLabel("게시물");
        JLabel jl_post_get = new JLabel("게시물");
        
        JLabel jl_following = new JLabel("팔로잉");
        JLabel jl_following_get = new JLabel("팔로잉");
        
        JLabel jl_follower = new JLabel("팔로워");
        JLabel jl_follower_get = new JLabel("팔로워");
        
        JLabel jl_ment = new JLabel("멘토멘티");
        JLabel jl_jumsu = new JLabel("점수");
        
        JLabel jl_nickname = new JLabel("닉네임");
        JLabel jl_prfmsg = new JLabel("상메");
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        
        /////////////////정보 리스트 선언부//////////////////////
        GridLayout bl = new GridLayout(6,0,30,20);
        
        JLabel jl_mem_name = new JLabel("이름",JLabel.LEFT);
        JLabel jl_user_name = new JLabel("");
        
        
        JLabel jl_ph = new JLabel("전화번호",JLabel.LEFT);
        JLabel jl_user_ph = new JLabel("010 3218 2912");
        
        
        JButton jbtn_myInfo = new JButton("내정보관리");
        MemberVO mvo = null;
        public myProfile() {
        	 mvo = new MemberVO();//나중에 DAO로 채워질 부분. NEW MEMBER VO 대신 DAO가 리턴하는 걸 받아서 넣으면 됨.
        	 mvo.setMem_name("거대토끼");
        	 mvo.setNick("뚱뚱이");
        	 mvo.setProfile_msg("다이어트중");
        	 initProfile();
        }
        public void initProfile() {
      
        	jp_profile.setLayout(new BoxLayout(jp_profile,BoxLayout.Y_AXIS));
        	jl_post.setHorizontalAlignment(SwingConstants.CENTER);
        	jl_post_get.setHorizontalAlignment(SwingConstants.CENTER);
        	
        	jl_following.setHorizontalAlignment(SwingConstants.CENTER);
        	jl_following_get.setHorizontalAlignment(SwingConstants.CENTER);
        	
        	jl_follower.setHorizontalAlignment(SwingConstants.CENTER);
        	jl_follower_get.setHorizontalAlignment(SwingConstants.CENTER);

        	jl_ment.setHorizontalAlignment(SwingConstants.LEFT);
        	jl_jumsu.setHorizontalAlignment(SwingConstants.RIGHT);
        	jl_nickname.setHorizontalAlignment(SwingConstants.CENTER);
        	jl_prfmsg.setHorizontalAlignment(SwingConstants.CENTER);
        	
        	jp_north.setLayout(gbl);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;

            
            make(jp_profile, 0, 0, 170, 130,1,2); // 아래의 make함수를 지정
            make(jl_post, 1, 0, 80, 175,1,3);
            make(jl_post_get, 1, 1, 80, 175,1,3);
            make(jl_following, 2, 0, 80, 175,1,3);
            make(jl_following_get, 2, 1, 80, 175,1,3);
            make(jl_follower, 3, 0, 80, 175,1,3);
            make(jl_follower_get, 3, 1, 80, 175,1,3);
            
            make(jl_ment, 0, 2, 170, 25,1,1);
            make(jl_jumsu, 0, 2, 170, 25,1,1);
            make(jl_nickname, 0, 3, 170, 25,1,1);
            make(jl_prfmsg, 1, 3, 240, 25,4,1);

            jp_north.add(jp_profile);
            jp_north.add(jl_post);
            jp_north.add(jl_post_get);
            
            jp_north.add(jl_following);
            jp_north.add(jl_following_get);
            
            jp_north.add(jl_follower);
            jp_north.add(jl_follower_get);
            
            jp_north.add(jl_ment);
            jp_north.add(jl_jumsu);
            jp_north.add(jl_nickname);
            jp_north.add(jl_prfmsg);

            
            
            //jp_main.setVisible(true);
            jl_user_name.setSize(10, 10);
            jp_south.setSize(410,345);
           	jp_south.setLayout(bl);
           	jp_south.setVisible(true);
           	jp_south.add(jl_mem_name);
        	jp_south.add(jl_user_name);
        	jp_south.add(jl_ph);
        	jp_south.add(jl_user_ph);
        	jp_south.add(jbtn_myInfo);
        	
        	
        	add(jp_north,BorderLayout.NORTH);
        	add(jp_south);
        	jp_north.setBackground(new Color(255,225,201));
        	
        	jp_south.setBorder(BorderFactory.createEmptyBorder(10 , 40 , 10 , 40)); 
        	jp_north.setBorder(BorderFactory.createEmptyBorder(10 , 40 , 10 , 40)); 
        	
        	jbtn_myInfo.setBackground(new Color(255,225,201));
        	
        	


        	jp_south.setBackground(new Color(255,225,201));
        	
        	
        	String imgName= "good.png";
        	ProfileImg img  = new ProfileImg(imgName,0,0,160,160);
        	jp_profile.add(img);
        	
            //////////////
        	jl_user_name.setText(mvo.getMem_name());
        	jl_nickname.setText(mvo.getNick());
        	jl_prfmsg.setText(mvo.getProfile_msg());
            // ------------------------------------------------

            //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // 프레임의 x버튼을 활성화하여 닫기버튼이 실행가능해짐
            jp_north.setSize(410, 200); // jp_north 사이즈
            //setVisible(true); // 프레임을 보이게 함
            setLocationRelativeTo(null); // 프레임 실행시 위치 중앙
            
        	this.setSize(410,545);
        	this.setVisible(false);
        }
       
        
     
        // make함수를 내가 지정합니다.

        // jcomponent인 jbutton의 객체에 x,y의 좌표의 시작점에서 w,h 크기의 단추를 만듭니다
        public void make(JComponent c, int x, int y, int w, int h, int q, int r) {
               gbc.gridx = x;
               gbc.gridy = y;
               gbc.ipadx=w;
               gbc.ipady=h;
               gbc.gridwidth = q;
               gbc.gridheight = r;
               gbl.setConstraints(c, gbc);
               // GridBagLayout의 GridBagConstraints의 set하는 방법
        }
        public static void main(String args[]) {
               
               

               
        }
}
