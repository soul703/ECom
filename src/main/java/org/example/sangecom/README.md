# E-Commerce Project  

## 🛒 **Giới thiệu**  
Dự án này là một hệ thống thương mại điện tử được xây dựng bằng **Java Spring Boot**. Hệ thống cung cấp các tính năng như quản lý người dùng, phân quyền, giỏ hàng, thanh toán, và phân trang.  

Giao diện được xây dựng bằng **Thymeleaf**, **HTML**, **CSS**, và **JavaScript**, đồng thời sử dụng cơ sở dữ liệu **MySQL** để lưu trữ thông tin sản phẩm, người dùng, và đơn hàng.  

---

## ✨ **Các tính năng chính**  

### **1. Quản lý người dùng và phân quyền**  
- **Admin:**  
  - Quản lý toàn bộ người dùng và sản phẩm.  
  - Phân quyền cho các tài khoản.  
  - Thêm/sửa/xóa sản phẩm của mình.  
  - Quản lý đơn hàng từ khách hàng.  
- **Customer:**  
  - Duyệt và mua sản phẩm.  
  - Quản lý đơn hàng cá nhân.  

### **2. Đăng ký/Đăng nhập**  
- Sử dụng **Spring Security** để bảo mật.  
- Hỗ trợ lưu phiên người dùng qua **cookies** và **session**.   

### **3. Quản lý sản phẩm**  
- Hiển thị danh sách sản phẩm với **phân trang**.  
- Tìm kiếm và lọc sản phẩm theo từ khóa, giá, hoặc danh mục.  

### **4. Giỏ hàng và thanh toán**  
- Thêm sản phẩm vào giỏ hàng.  
- Hiển thị tổng giá trị đơn hàng.  
- Hỗ trợ thanh toán (giả lập).  

### **5. Quản lý đơn hàng**  
- Seller theo dõi đơn hàng.  
- Customer kiểm tra trạng thái đơn hàng.  

---

## 🛠 **Công nghệ sử dụng**  

### **Backend**  
- **Java Spring Boot:** Quản lý logic hệ thống.  
- **Spring Security:** Quản lý đăng nhập, phân quyền.  
- **JPA/Hibernate:** Tương tác với cơ sở dữ liệu.  
- **MySQL:** Lưu trữ thông tin.  

### **Frontend**  
- **Thymeleaf:** Tạo giao diện động.  
- **HTML/CSS/JS:** Xây dựng giao diện người dùng.  
- **Bootstrap:** Thiết kế giao diện responsive.  

### **Công cụ hỗ trợ**  
- **Maven:** Quản lý thư viện.  
- **Lombok:** Giảm mã boilerplate.  
- **Postman:** Kiểm thử API.  
- **Git/GitHub:** Quản lý mã nguồn.  

---

## 📂 **Cấu trúc dự án**  
```plaintext
src/
├── main/
│   ├── java/com/example/ecommerce/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   └── EcommerceApplication.java
│   └── resources/
│       ├── templates/
│       ├── static/
│       └── application.properties
