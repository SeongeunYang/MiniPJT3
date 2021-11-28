<h3 align="center"><b>개인 미니프로젝트, 초록 나무 숲 게시판</b></h3>

<h4 align="center">📆 2021.11.23 ~ 2021.11.26</h4>
<h4 align="center"><b>🎫 자유 게시판을 만들어보았다. 누구나 글을 볼 수 있지만 글쓰기와 댓글쓰기는 로그인을 한 유저만 사용 가능한 게시판이다. 🎫</b></h4>
<br><br> 

---

<br>
<h3 align="center"><b>🛠 Tech Stack 🛠</b></h3>
<p align="center">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/jquery-0769AD?style=for-the-badge&logo=jquery&logoColor=white">
<img src="https://img.shields.io/badge/html-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/linux-FCC624?style=for-the-badge&logo=linux&logoColor=black">
<img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=aws&logoColor=white">
</br>
<img src="https://img.shields.io/badge/Java-F80000?style=for-the-badge&logo=Java&logoColor=white">
<img src="https://img.shields.io/badge/SpringBoot-4FC08D?style=for-the-badge&logo=SpringBoot&logoColor=white">
<img src="https://img.shields.io/badge/Thymeleaf-7952B3?style=for-the-badge&logo=Thymeleaf&logoColor=white">
<img src="https://img.shields.io/badge/Mysql-61DAFB?style=for-the-badge&logo=Mysql&logoColor=white">
<img src="https://img.shields.io/badge/SpringSecurity-F7DF1E?style=for-the-badge&logo=SpringSecurity&logoColor=black">

<br><br>
<h3 align="center"><b>📂 Project Directory Structure 📁</b></h3>
<pre>
<code>
/main
  └──/java
     └──/com.sparta.miniproject
          └──/controller
               ├── /BoardController.java
               ├── /CommentController.java
               ├── /HomeController.java
               ├── /KakaoUserController.java
               └── /UserController.java
          └──/dto
               ├── /CommentRequestDto.java
               ├── /KakaoUserInfoDto.java
               ├── /PostRequestDto.java
               └── /UserInfoDto.java
          └──/model
               ├── /Comment.java
               ├── /Post.java
               ├── /Timestamped.java
               └── /User.java
          └──/repository
               ├── /CommentRepository.java
               ├── /PostRepository.java
               └── /UserRepository.java
          └──/service
               ├── /BoardService.java
               ├── /CommentService.java
               ├── /KakaoUserService.java
               └── /UserService.java
          └──/validator
               └── /UserInfoValidator.java
          └──/MiniPjt3Application.java
  └──/resources
     └──/static
         └──/css
             ├── /board.css
             └── /login.css
         └──/images
             ├── /delete.png
             ├── /done.png
             ├── /edit.png
             └── /send.png
         └──/js
             ├── /board.js
             ├── /detailpost.js
             ├── /newpost.js
             └── /signup.js
     └──/templates
         ├── /board.html
         ├── /detailpost.html
         ├── /login.html
         ├── /needlogin.html
         ├── /newpost.html
         ├── /prelogin.html
         └── /signup.html
     └──/application.properties
</code>
</pre>
<br>

---

<h3 align="center"><b>📢 Main function 📢</b></h3>
<br>
<h4><b>📰 Postlist Page(Main Page) 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%">
            <img src="https://user-images.githubusercontent.com/57797592/143762899-94d65e9d-f3e2-4d1a-817d-bdcca8beb9c7.png" />
            <img src="https://user-images.githubusercontent.com/57797592/143762416-2c231b7b-60e1-4397-95e7-cade8e37384a.png" />
        </td>
        <td width="50%">
            <h5>작성 글 목록</h5>
            <h6>공통 기능</h6>
            <ul>
                <li>글 제목으로 검색 기능 구현</li>
                <li>특정 글 클릭 시 상세 페이지로 이동</li>
            </ul>
            <h6>로그인 한 User</h6>
            <ul>
                <li>글쓰기 버튼 클릭 시 글 작성 가능</li>
                <li>로그아웃 버튼 클릭 시 로그아웃</li>
                <li>내가 쓴 게시글 삭제 가능</li>
            </ul>
            <h6>Guest User</h6>
            <ul>
                <li>회원가입 버튼</li>
                <li>로그인 버튼</li>
            </ul>
        </td>
    </tr>
</table>

---

<br>
<h4><b>📰 PostWrite Page 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%"><img src="https://user-images.githubusercontent.com/57797592/143762963-bdfa0c57-98a2-4246-8322-d33a4d0df84a.png" /></td>
        <td width="50%">
            <h5>글 작성</h5>
            <ul>
                <li>제목, 내용을 작성할 수 있는 입력란</li>
                <li>저장 버튼 클릭 시, DB에 해당 글이 저장</li>
                <li>저장 조건 - 모든 입력란을 기입하여야 함, 로그인이 되어 있어야 함</li>
            </ul>
        </td>
    </tr>
</table>

---

<br>
<h4><b>📰 Post Detail Page 📰</b></h4>

<table width="100%">
    <tr>
        <td width="50%"><img src="https://user-images.githubusercontent.com/57797592/143763003-7b396a87-b2ff-4c4b-9be3-ec52614b11b6.png" /></td>
        <td width="50%">
            <h5>글 상세 화면</h5>
            <ul>
                <li>클릭한 포스트의 정보를 볼 수 있음</li>
                <li>내가 작성한 글일 때 삭제 기능</li>
                <li>로그인이 되어 있을 때 댓글 작성 가능</li>
                <li>내가 작성한 댓글일 때 수정, 삭제 가능</li>
            </ul>
        </td>
    </tr>
</table>
<br>

---
