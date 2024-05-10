import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame
{
   public Main()
   {
   initComponents();
   }
  public void initComponents()
  {
      this.setTitle("Menu");
      this.setBounds(300 ,300 ,300 ,200);
      
      panelMenu.setLayout(new GridLayout(3,1));
      panelMenu.add(menu1);
      panelMenu.add(menu2);
      panelMenu.add(menu3);
      //  adding new MenuButton to panel
      container.add(panelMenu);
      this.setDefaultCloseOperation(3);
  }  
  
  private Container container = this.getContentPane();
  private JPanel panelMenu = new JPanel();
  
  private MenuButton menu1 =new MenuButton("1. add");
  private MenuButton menu2 =new MenuButton("2. delete");
  private MenuButton menu3 =new MenuButton("3. change");
//  adding new MenuButton
 private int i =0 ;
//  int for key moving on menu
  private class MenuButton extends JButton implements FocusListener, ActionListener
  {
      public MenuButton(String name)
      {
          super(name);
          
          this.addFocusListener(this);
          this.addActionListener(this);
          this.addKeyListener(new KeyAdapter(){
              @Override
              public void keyPressed(KeyEvent e) 
              {
                  keyPressedHandler(e);
              }

          });
          this.setBackground(kDefault);
    // button        
      }

        public void focusGained(FocusEvent e) 
        {
            this.setBackground(kFocusGained);
        }
 //        changing color when focusing        
        public void focusLost(FocusEvent e) 
        {
          this.setBackground(kDefault);
        }
//        changing color when focus lost
         private void keyPressedHandler(KeyEvent e)
          {
              int menuLenght = panelMenu.getComponentCount();
              if(i==0) i = menuLenght;
              if (e.getKeyCode()== KeyEvent.VK_DOWN)
              {
                  panelMenu.getComponent(++i%menuLenght).requestFocus();
              }
//  what program do affter cliking arrow down              
              else if (e.getKeyCode()== KeyEvent.VK_UP)
              {
                  panelMenu.getComponent(--i%menuLenght).requestFocus();
              }
 //  what program do affter cliking arrow up 
               else if (e.getKeyCode()== KeyEvent.VK_ENTER)
              {
                  ((MenuButton)e.getSource()).doClick();
              }
          }
//  what program do affter cliking enter       
          public void actionPerformed(ActionEvent e) 
        {
            JOptionPane.showMessageDialog(this, ((MenuButton)e.getSource()).getText());
        }
//action after we click on button
          private Color kFocusGained = Color.WHITE;
          private Color kDefault = Color.LIGHT_GRAY;
//button colors (kDefault is when focus lost , kkFocusGained when we focusing button)
      
       
  }
  
public static void main(String[] args) 
    {
        new Main().setVisible(true);
    }
 
}
