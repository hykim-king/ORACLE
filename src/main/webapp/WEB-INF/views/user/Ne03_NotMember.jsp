<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style id="fullpage_styles">
        @font-face {
            font-family: 'Cafe24Dongdong';
            src:
                    url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_twelve@1.1/Cafe24Dongdong.woff')
                    format('woff');
            font-weight: normal;
            font-style: normal;
        }

        @font-face {
            font-family: 'NeoDunggeunmo';
            src:
                    url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2001@1.3/NeoDunggeunmo.woff')
                    format('woff');
            font-weight: normal;
            font-style: normal;
        }

        h2 {
            font-family: 'Cafe24Dongdong';
        }

        select {
            width: 150px;
            padding: 0.5em;
            border: 1px solid #999;
            border-radius: 5px;
        }

        .name {
            width: 150px;
            padding: 0.5em;
            border: 1px solid #999;
            border-radius: 5px;
        }

        button {
            font-family: 'NeoDunggeunmo';
        }

        .config {
            background-color: #FFD500;
            border: none;
            color: black;
            padding: 15px 128px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 5px;
            margin: 4px 2px;
        }
    </style>
</head>
<body id="tinymce" class="mce-content-body" data-id="content"
      contenteditable="true" spellcheck="false">
<h2 style="text-align: center;">MBTI를 입력하세요</h2>
<div style="text-align: center;">
    <form>
        <select name="mbti">
            <option style="text-align: center;" value="none">=== 선택 ===</option>
            <option value="ISTJ">ISTJ</option>
            <option value="ISTP">ISTP</option>
            <option value="ISFJ">ISFJ</option>
            <option value="ISFP">ISFP</option>
            <option value="INTJ">INTJ</option>
            <option value="INTP">INTP</option>
            <option value="INFJ">INFJ</option>
            <option value="INFP">INFP</option>
            <option value="ESTJ">ESTJ</option>
            <option value="ESTP">ESTP</option>
            <option value="ESFJ">ESFJ</option>
            <option value="ESFP">ESFP</option>
            <option value="ENTJ">ENTJ</option>
            <option value="ENTP">ENTP</option>
            <option value="ENFJ">ENFJ</option>
            <option value="ENFP">ENFP</option>
        </select>
    </form>
</div>
<h2 style="text-align: center;">닉네임을 입력하세요</h2>
<div style="text-align: center;">
    <input class="name" maxlength="30" required="" size="10" type="text" />
</div>
<h2 style="text-align: center;">성별을 입력하세요</h2>
<div style="text-align: center;">
    <input name="gender1" type="radio" /> 남자 <input name="gender1"
                                                    type="radio" /> 여자
</div>
<h2 style="text-align: center;">띠를 입력하세요</h2>
<div style="text-align: center;">
    <form>
        <select name="mbti">
            <option style="text-align: center;" value="none">=== 선택 ===</option>
            <option value="mouse">쥐띠</option>
            <option value="cow">소띠</option>
            <option value="tiger">호랑이띠</option>
            <option value="rabbit">토끼띠</option>
            <option value="dragon">용띠</option>
            <option value="snake">뱀띠</option>
            <option value="horse">말띠</option>
            <option value="sheep">양띠</option>
            <option value="monkey">원숭이띠</option>
            <option value="chicken">닭띠</option>
            <option value="dog">개띠</option>
            <option value="pig">돼지띠</option>
        </select>
    </form>
</div>
<h2 style="text-align: center;">현재(서버시간)의 네 팔자야</h2>
<div style="text-align: center;">
    <button class="config" type="submit">운세 확인</button>
</div>
</body>
</html>