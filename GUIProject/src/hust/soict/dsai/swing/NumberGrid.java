package hust.soict.dsai.swing;

import javax.swing.*; // Thư viện Swing
import java.awt.*;    // Thư viện hỗ trợ bố cục
import java.awt.event.*; // Thư viện xử lý sự kiện

// Lớp chính tạo giao diện số hóa đơn giản
public class NumberGrid extends JFrame {

    private JButton[] btnNumbers = new JButton[10]; // Mảng nút bấm số từ 0-9
    private JButton btnDelete, btnReset;            // Nút xóa và nút đặt lại
    private JTextField tfDisplay;                  // Ô hiển thị số

    // Constructor thiết lập giao diện và xử lý sự kiện
    public NumberGrid() {
        // Tạo ô hiển thị và thiết lập hiển thị số từ phải sang trái
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Tạo panel chứa các nút bấm và sử dụng lưới 4x3
        JPanel panelButtons = new JPanel(new GridLayout(4, 3));
        addButtons(panelButtons); // Thêm các nút bấm vào panel

        // Thiết lập bố cục cho Container
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);   // Đặt ô hiển thị ở phía trên
        cp.add(panelButtons, BorderLayout.CENTER); // Đặt các nút ở giữa

        // Thiết lập thuộc tính cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(200, 200); // Kích thước cửa sổ
        setVisible(true);  // Hiển thị cửa sổ
    }

    // Phương thức chính để chạy chương trình
    public static void main(String[] args) {
        new NumberGrid(); // Tạo đối tượng giao diện
    }

    // Phương thức thêm các nút bấm vào panel
    void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener(); // Tạo trình lắng nghe sự kiện

        // Thêm các nút bấm từ 1 đến 9 vào panel và gắn sự kiện
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i); // Tạo nút với số tương ứng
            panelButtons.add(btnNumbers[i]);    // Thêm nút vào panel
            btnNumbers[i].addActionListener(btnListener); // Gắn sự kiện
        }

        // Thêm nút DELETE
        btnDelete = new JButton("DELETE");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Thêm nút 0
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Thêm nút Reset (C)
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }
    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand(); // Lấy lệnh từ nút được nhấn

            // Kiểm tra nếu nút bấm là một số (ký tự từ '0' đến '9')
            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                tfDisplay.setText(tfDisplay.getText() + button); // Thêm số vào ô hiển thị
            }
            // Xử lý trường hợp nút bấm là "DEL" (Xóa ký tự cuối cùng)
            else if (button.equals("DEL")) {
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    // Xóa ký tự cuối cùng trong chuỗi
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            }
            // Xử lý trường hợp nút bấm là "C" (Reset - xóa toàn bộ nội dung)
            else if (button.equals("C")) {
                tfDisplay.setText(""); // Đặt lại ô hiển thị
            }
        }
    }
}
