$(function() {
	// Phương thức kiểm tra tùy chỉnh
	jQuery.validator.addMethod('lettersonly', function(value, element) {
		return /^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂĂêÔơÁáíýụýẮặâếỂử\s]+$/.test(value); // Hỗ trợ tiếng Việt
	}, 'Tên chỉ được chứa chữ cái.');

	jQuery.validator.addMethod('space', function(value, element) {
		return /^[^\s]+$/.test(value);
	}, 'Không được chứa khoảng trắng.');

	jQuery.validator.addMethod('all', function(value, element) {
		return /^[^-\s][a-zA-Z0-9_,.\s-]+$/.test(value);
	}, 'Chỉ được chứa ký tự hợp lệ.');

	jQuery.validator.addMethod('numericOnly', function(value, element) {
		return /^[0-9]+$/.test(value);
	}, 'Chỉ được chứa số.');

	// Xác thực đăng ký
	var $userRegister = $("#userRegister");

	$userRegister.validate({
		rules: {
			name: {
				required: true,
				lettersonly: true
			},
			email: {
				required: true,
				email: true
			},
			mobileNumber: {
				required: true,
				numericOnly: true,
				minlength: 10,
				maxlength: 12
			},
			password: {
				required: true,
				minlength: 8
			},
			confirmpassword: {
				required: true,
				equalTo: '#pass'
			},
			address: {
				required: true,
				all: true
			},
			city: {
				required: true
			},
			state: {
				required: true
			},
			pincode: {
				required: true,
				numericOnly: true,
				minlength: 5
			},
			img: {
				required: true,
				extension: "jpg|jpeg|png|gif"
			}
		},
		messages: {
			name: {
				required: 'Vui lòng nhập tên.',
				lettersonly: 'Tên chỉ được chứa chữ cái.'
			},
			email: {
				required: 'Vui lòng nhập email.',
				email: 'Email không hợp lệ.'
			},
			mobileNumber: {
				required: 'Vui lòng nhập số điện thoại.',
				numericOnly: 'Chỉ được chứa số.',
				minlength: 'Số điện thoại phải có ít nhất 10 chữ số.',
				maxlength: 'Số điện thoại không vượt quá 12 chữ số.'
			},
			password: {
				required: 'Vui lòng nhập mật khẩu.',
				minlength: 'Mật khẩu phải có ít nhất 8 ký tự.'
			},
			confirmpassword: {
				required: 'Vui lòng xác nhận mật khẩu.',
				equalTo: 'Mật khẩu không khớp.'
			},
			address: {
				required: 'Vui lòng nhập địa chỉ.'
			},
			city: {
				required: 'Vui lòng nhập thành phố.'
			},
			state: {
				required: 'Vui lòng chọn tỉnh/thành phố.'
			},
			pincode: {
				required: 'Vui lòng nhập mã bưu điện.',
				numericOnly: 'Chỉ được chứa số.',
				minlength: 'Mã bưu điện phải có ít nhất 5 số.'
			},
			img: {
				required: 'Vui lòng chọn hình ảnh.',
				extension: 'Chỉ chấp nhận định dạng jpg, jpeg, png, gif.'
			}
		},
		errorPlacement: function(error, element) {
			element.addClass('is-invalid'); // Thêm lớp cho input khi lỗi
			error.insertAfter(element);
		},
		success: function(label, element) {
			$(element).removeClass('is-invalid').addClass('is-valid'); // Giao diện khi hợp lệ
		}
	});

	// Xác thực đặt hàng
	var $orders = $("#orders");

	$orders.validate({
		rules: {
			firstName: {
				required: true,
				lettersonly: true
			},
			lastName: {
				required: true,
				lettersonly: true
			},
			email: {
				required: true,
				email: true
			},
			mobileNo: {
				required: true,
				numericOnly: true,
				minlength: 10,
				maxlength: 12
			},
			address: {
				required: true,
				all: true
			},
			city: {
				required: true
			},
			state: {
				required: true
			},
			pincode: {
				required: true,
				numericOnly: true,
				minlength: 5
			},
			paymentType: {
				required: true
			}
		},
		messages: {
			firstName: {
				required: 'Vui lòng nhập tên.',
				lettersonly: 'Tên chỉ được chứa chữ cái.'
			},
			lastName: {
				required: 'Vui lòng nhập họ.',
				lettersonly: 'Họ chỉ được chứa chữ cái.'
			},
			email: {
				required: 'Vui lòng nhập email.',
				email: 'Email không hợp lệ.'
			},
			mobileNo: {
				required: 'Vui lòng nhập số điện thoại.',
				numericOnly: 'Chỉ được chứa số.',
				minlength: 'Số điện thoại phải có ít nhất 10 chữ số.',
				maxlength: 'Số điện thoại không vượt quá 12 chữ số.'
			},
			address: {
				required: 'Vui lòng nhập địa chỉ.'
			},
			city: {
				required: 'Vui lòng nhập thành phố.'
			},
			state: {
				required: 'Vui lòng chọn tỉnh/thành phố.'
			},
			pincode: {
				required: 'Vui lòng nhập mã bưu điện.',
				numericOnly: 'Chỉ được chứa số.',
				minlength: 'Mã bưu điện phải có ít nhất 5 số.'
			},
			paymentType: {
				required: 'Vui lòng chọn phương thức thanh toán.'
			}
		},
		errorPlacement: function(error, element) {
			element.addClass('is-invalid');
			error.insertAfter(element);
		},
		success: function(label, element) {
			$(element).removeClass('is-invalid').addClass('is-valid');
		}
	});

	// Xác thực đặt lại mật khẩu
	var $resetPassword = $("#resetPassword");

	$resetPassword.validate({
		rules: {
			password: {
				required: true,
				minlength: 8
			},
			confirmPassword: {
				required: true,
				equalTo: '#pass'
			}
		},
		messages: {
			password: {
				required: 'Vui lòng nhập mật khẩu.',
				minlength: 'Mật khẩu phải có ít nhất 8 ký tự.'
			},
			confirmPassword: {
				required: 'Vui lòng xác nhận mật khẩu.',
				equalTo: 'Mật khẩu không khớp.'
			}
		},
		errorPlacement: function(error, element) {
			element.addClass('is-invalid');
			error.insertAfter(element);
		},
		success: function(label, element) {
			$(element).removeClass('is-invalid').addClass('is-valid');
		}
	});
});
