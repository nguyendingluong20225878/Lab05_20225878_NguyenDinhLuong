// Package thuộc thư viện Java
package hust.soict.dsai.swing;

import java.awt.*; // Thư viện giao diện đồ họa AWT
import java.awt.event.*; // Thư viện xử lý sự kiện AWT

// Lớp chính tạo một chương trình tính tổng tích lũy với giao diện AWT
public class AWTAccumulator extends Frame {
    
    // Các thành phần giao diện: ô nhập dữ liệu và ô hiển thị kết quả
    private TextField tfInput; // Ô nhập
    private TextField tfOutput; // Ô xuất (hiển thị tổng)
    private int sum = 0; // Biến lưu tổng tích lũy

    // Constructor thiết lập giao diện và xử lý sự kiện
    public AWTAccumulator() {
        // Sử dụng bố cục GridLayout với 2 hàng, 2 cột
        setLayout(new GridLayout(2, 2));

        // Thêm nhãn cho ô nhập dữ liệu
        add(new Label("Nhập một số nguyên: "));

        // Tạo và thêm ô nhập dữ liệu
        tfInput = new TextField(10);
        add(tfInput);

        // Gắn trình lắng nghe sự kiện cho ô nhập dữ liệu
        tfInput.addActionListener(new TfInputListener());

        // Thêm nhãn cho ô hiển thị kết quả
        add(new Label("Tổng tích lũy: "));

        // Tạo và thêm ô xuất kết quả
        tfOutput = new TextField(10);
        tfOutput.setEditable(false); // Không cho phép chỉnh sửa ô kết quả
        add(tfOutput);

        // Thiết lập thuộc tính cho cửa sổ
        setTitle("AWT Accumulator"); // Tiêu đề của cửa sổ
        setSize(350, 120); // Kích thước cửa sổ
        setVisible(true); // Hiển thị cửa sổ
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        new AWTAccumulator(); // Tạo đối tượng AWTAccumulator
    }

    // Lớp nội bộ để xử lý sự kiện khi nhấn Enter trong ô nhập dữ liệu
    private class TfInputListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Lấy giá trị từ ô nhập, chuyển thành số nguyên
            int numberIn = Integer.parseInt(tfInput.getText());
            sum += numberIn; // Cộng vào tổng tích lũy
            tfInput.setText(""); // Xóa nội dung trong ô nhập
            tfOutput.setText(sum + ""); // Hiển thị tổng tích lũy trong ô kết quả
        }
    }
}
