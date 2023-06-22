<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="author" content="user">
    <style>
        * {
            text-align: center;
        }
        @font-face {
            font-family: 'Hahmlet-Regular';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2110@1.0/Hahmlet-Regular.woff2') format('woff2');
            font-weight: normal;
            font-style: normal;
        }
        @font-face {
            font-family: 'NeoDunggeunmo';
            src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.3/NeoDunggeunmo.woff') format('woff');
            font-weight: normal;
            font-style: normal;
        }
        .wrapper {
            display: flex;
            justify-content: center;
            align-items: flex-start;
        }
        .box {
            margin: 20px auto;
            padding: 20px;
            border: 10px solid #dddddd;
            width: 200px;
            box-sizing: content-box;
            font-size: 70%;
        }
        p {
            font-family: 'Hahmlet-Regular';
            font-size: 200%;
            font-weight: 900;
        }

        button {
            margin: 20px;
            font-family: 'NeoDunggeunmo';
        }

        .w-btn-outline {
            position: relative;
            padding: 15px 30px;
            border-radius: 15px;
            box-shadow: 0 15px 35px rgba(0, 0, 0, 0.2);
            font-family: 'NeoDunggeunmo';
            text-decoration: none;
            font-weight: 600;
            transition: 0.25s;
            border: 3px solid #fce205;
        }

        .w-btn-yellow-outline {
            background-color: #fce205;
            border-color: #fce205;
        }

        .w-btn-yellow-outline:hover {
            background-color: #ffffff;
            color: #fce205;
        }

        footer {
            text-align: right;
            font-size: xx-small;
        }
    </style>
    <title>5번 페이지</title>
</head>
<body>
<div class="wrapper">
    <div class="box">
        <span id="username"></span>님 안녕하세요 
    </div>
</div>
<div>
    <p>Curious about your luck?</p>
    <p>Check your luck!</p>
</div>
<button class="w-btn-outline w-btn-yellow-outline" type="button"
        onclick="location.href='Ne10_ResultUrl.html'">
    이전 운세 확인
</button>
<button class="w-btn-outline w-btn-yellow-outline" type="button"
        onclick="location.href='Ne05_MemberResultPage.html'">
    오늘 운세 확인
</button>
<div>
    <footer>NE PAL ZZA YA(NPZY)</footer>
</div>
<script>
    // 데이터베이스에서 이름 가져오기
    var username = "${sessionScope.user}"; // 예시 이름, 실제로는 데이터베이스에서 가져온 값을 사용하세요.

    // HTML 요소에 동적으로 이름 삽입
    var usernameElement = document.getElementById("username");
    usernameElement.textContent = username;
</script>
</body>
</html>