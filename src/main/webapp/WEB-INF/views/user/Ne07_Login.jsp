<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <style>
        body {
            font-family: NeoDunggeunmo, Cafe24Dongdong;
            background-color: #F4F4F4;
        }
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 30px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ddd;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            cursor: pointer;
        }
        .form-group .signup-link {
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>NE PAL ZZY YA</h2>
    <form>
        <div class="form-group">
            <label for="username">ID:</label> <input type="text" id="username"
                                                     name="username" required>
        </div>
        <div class="form-group">
            <label for="password">PW:</label> <input type="password"
                                                     id="password" name="password" required>
        </div>
        <div class="form-group">
            <button type="submit"
                    onclick="location.href='Ne09_MyPage.html'">
                >로그인</button>
        </div>
        <div class="form-group signup-link">
            <a href="Ne08_SignUp.html">회원가입</a>
        </div>
    </form>
</div>
</body>
</html>