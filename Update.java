import javax.swing.JOptionPane;

public class Update {

    public void update( String username, String password) {
    
        String ch;
        JOptionPane.showMessageDialog(null,"\n Your password: "+password);
        ch=JOptionPane.showInputDialog("enter your choice\n (NOTE:\n name-->1 \n email-->2):");
        int choice=Integer.valueOf(ch);
        switch(choice)
        {
            case 1:
                username=JOptionPane.showInputDialog("enter your Name: ");
                JOptionPane.showMessageDialog(null," Your updated Name: "+username);
                break;
            case 2:
                password=JOptionPane.showInputDialog("enter your password:");
                JOptionPane.showMessageDialog(null," Your password: "+password);
                break;
            default:
                JOptionPane.showMessageDialog(null,"You entered invalid option");
                break;
            }
            JOptionPane.showMessageDialog(null,"UPDATED DETAILS:\n Your Name: "+username+"\n Your password: "+password);
    
    }

}
