package homework3io;
//Малыгин Андрей, домашнее задание к 3 уроку Java3.
//В данном классе использовал FileOutputStream для создания при работе в чате
// файла history_name.txt в методе sendMsg
// и записи в него текста сообщений. строки кода 132 - 138.
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends JFrame {

    private final String SERVER_HOST = "localhost";
    private final int SERVER_PORT = 8888;

    private Socket clientSocket;
    private Scanner inMsg;
    private PrintWriter outMsg;

    private JTextField jtfMsg;
    private JTextField jtfName;
    private JTextArea jTextAreaMsg;

    public Client() throws HeadlessException {
        try {
            clientSocket = new Socket(SERVER_HOST, SERVER_PORT);
            inMsg = new Scanner(clientSocket.getInputStream());
            outMsg = new PrintWriter(clientSocket.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
        setBounds(600, 100, 500, 500);
        setTitle("Client of chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //текстовое поле
        jTextAreaMsg = new JTextArea();
        jTextAreaMsg.setEditable(false);
        jTextAreaMsg.setLineWrap(true);
        add(new JScrollPane(jTextAreaMsg), BorderLayout.CENTER);

        JLabel labelCountOfClient = new JLabel("Count of client in chat: ");
        add(labelCountOfClient, BorderLayout.NORTH);

        JLabel countsOfClientsLabel = new JLabel("Counts of clients in chat: ");
        add(countsOfClientsLabel, BorderLayout.NORTH);

        //панель для ввода сообщений
        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);

        JButton sendButton = new JButton("Отправить");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        jtfMsg = new JTextField("Please input your message");
        bottomPanel.add(jtfMsg, BorderLayout.CENTER);

        jtfName = new JTextField("Your name");
        bottomPanel.add(jtfName, BorderLayout.WEST);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = jtfMsg.getText().trim();
                String name = jtfName.getText().trim();
                if (!msg.isEmpty() && !name.isEmpty()) {
                    sendMsg();
                    jtfMsg.grabFocus();
                }
            }
        });
        jtfMsg.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfMsg.setText("");
            }
        });
        jtfName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                jtfName.setText("");
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    String msg = inMsg.nextLine();
                    String clientInChat = "Counts of clients in chat: ";
                    if (msg.indexOf(clientInChat) == 0){
                        countsOfClientsLabel.setText(clientInChat);
                    } else {
                        jTextAreaMsg.append(msg);
                        jTextAreaMsg.append("\n");
                    }

                }
            }
        }).start();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                String clientName = jtfName.getText();
                if (!clientName.isEmpty() && !clientName.equalsIgnoreCase("Your name")){
                    outMsg.println(clientName + ": exited from chat");
                } else {
                    outMsg.println("Anonymous client exited from our chat");
                }
                outMsg.println("QUIT");
                outMsg.flush();
                outMsg.close();
                inMsg.close();
                try {
                    clientSocket.close();
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        setVisible(true);
    }

    private void sendMsg(){
        String msg = jtfName.getText() + ": " + jtfMsg.getText();
        outMsg.println(msg);

        //запись сообщения в отдельный файл
        byte[] outDate = msg.getBytes();
        try (FileOutputStream out = new FileOutputStream("D:\\Java3\\history_" + jtfName.getText() + ".txt", true)){
            out.write(outDate);
        } catch (IOException e){
            e.printStackTrace();
        }

        outMsg.flush();
        jtfMsg.setText("");

    }
}
