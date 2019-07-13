package com.test;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.util.DBConnectionMgr;
 
public class BlobSelect extends JPanel{
	
	BufferedImage bi = null;
	
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400, 400);
    	BlobSelect bs = new BlobSelect();
      
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null; //select 의 결과를 저장
        
        try {
        	con = DBConnectionMgr.getConnection();
            stmt = con.prepareStatement("select image from member");
            rs = stmt.executeQuery();
            
            if(rs.next()){
                do{
                    InputStream is = rs.getBinaryStream("image");
                    bs.bi = ImageIO.read(is);
                    bs.repaint();
                }while(rs.next());
            }
            else{//없을때
                System.out.println("데이터가 없습니당");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
                //사용한 객체 close
                try {
                    if(rs != null) rs.close();
                    if(con != null) con.close();
                    if(stmt != null) stmt.close();
                    
                } catch (Exception e) {
                    
                }
        }
        jf.add(bs);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
        
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bi, null, 0, 0);
    }

}
