package hust.soict.dsai.swing;
import javax.swing.*; // Thư viện Swing
import java.awt.*;    // Thư viện hỗ trợ bố cục
import java.awt.event.*; // Thư viện xử lý sự kiện

// Lớp chính tạo giao diện tính tổng tích lũy bằng Swing
public class SwingAccumulator extends JFrame {

    private JTextField tfInput;  // Ô nhập liệu
    private JTextField tfOutput; // Ô hiển thị kết quả
    private int sum = 0;         // Biến lưu tổng tích lũy, khởi tạo bằng 0

    // Constructor thiết lập giao diện và xử lý sự kiện
    public SwingAccumulator() {
        // Lấy Container để thêm các thành phần giao diện
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2)); // Sử dụng bố cục lưới 2x2

        // Thêm nhãn và ô nhập dữ liệu
        cp.add(new JLabel("Nhập một số nguyên: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Xử lý sự kiện khi nhấn Enter

        // Thêm nhãn và ô hiển thị kết quả
        cp.add(new JLabel("Tổng tích lũy: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false); // Không cho phép chỉnh sửa ô kết quả
        cp.add(tfOutput);

        // Thiết lập thuộc tính cửa sổ
        setTitle("Swing Accumulator"); // Tiêu đề
        setSize(350, 120);             // Kích thước cửa sổ
        setVisible(true);              // Hiển thị cửa sổ
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        new SwingAccumulator(); // Tạo đối tượng giao diện
    }

    // Lớp nội bộ xử lý sự kiện khi nhấn Enter trong ô nhập liệu
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            // Lấy giá trị từ ô nhập, chuyển thành số nguyên
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn; // Cộng vào tổng tích lũy
            tfInput.setText(""); // Xóa nội dung ô nhập
            tfOutput.setText(sum + ""); // Hiển thị tổng tích lũy trong ô kết quả
        }
    }
}
