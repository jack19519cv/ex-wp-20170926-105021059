import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Mainframe extends Frame {
    private Button BtnAdd = new Button("ADD");
    private Button BtnSub = new Button("SUB");
    private Button Btnexit = new Button("EXIT");
    private Label lb = new Label("0.0");
    private int n=0, lbx=25,lby=60;
    private Timer t1;
    private boolean flag=true;
   public Mainframe(){
       init();
   }
   private void init(){
       this.setBounds(100,100,500,400);
       addWindowListener(new WindowAdapter() {
           @Override
           public void windowClosing(WindowEvent e) {
              System.exit(0);
           }
       });
       this.setLayout(null);
       BtnAdd.setBounds(140,270,60,40);
       this.add(BtnAdd);
       lb.setBounds(lbx,lby,50,30 );
       this.add( lb);
       BtnSub.setBounds(280,270,60,40);
       this.add(BtnSub);
       Mainframe.this.setTitle("0.0");
       BtnAdd.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
             //  lb.setText(Integer.toString(++n));
               Mainframe.this.setTitle(Integer.toString(++n));
               t1.start();
           }
       });
       BtnSub.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
              // lb.setText(Integer.toString(--n));
               Mainframe.this.setTitle(Integer.toString(--n));
               t1.stop();
           }
       });
       Btnexit.setBounds(210,270,60,40);
       this.add(Btnexit);
       Btnexit.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
            System.exit(0);
           }
       });
         lb.setAlignment(Label.CENTER);
   t1 = new Timer(200, new ActionListener() {
       @Override
       public void actionPerformed(ActionEvent e) {
         int c=lb.getX();
    if(lb.getX()>Mainframe.this.getWidth()-75){
      flag=false;
    }
    else if(lb.getX()<15){
     flag=true;
    }
    if(flag==true){
         lb.setText(Integer.toString(lb.getX())+","+Integer.toString(lb.getY()));
        lb.setLocation(lb.getX()+20, lb.getY());
        lb.setBackground(new Color(255,c/=2,c/=2));
    }else{
        lb.setText(Integer.toString(lb.getX())+","+Integer.toString(lb.getY()));
        lb.setLocation(lb.getX()-20, lb.getY());
       lb.setBackground(new Color(255,c/=2,c/=2));

    }



       }
   });




   }
}
