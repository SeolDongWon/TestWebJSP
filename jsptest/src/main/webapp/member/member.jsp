<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
  <div class="container w-50 border border-1 border-black mt-5 mb-5">
    <div class="input-form-backgroud row">
      <div class="input-form col-md-12 mx-auto">
        <h4 class="mb-3 d-flex justify-content-center">회원가입</h4>
        <!-- 화면 이동 action="memberInsert.jsp" method="post" -->
        <form class="validation-form" action="memberInsert.jsp" method="post">
          <div class="row">
            <div class="col-md-12 mb-3">
              <label for="name">아아디</label>
              <input type="text" class="form-control" id="id" name="id" placeholder="" value="" required>
              
              <div class="invalid-feedback"> 이름을 입력해주세요.</div>
            </div>
            <div class="col-md-12 mb-3">
              <label for="nickname">이름</label>
              <input type="text" class="form-control" id="name" name="name" placeholder="" value="" required>
              <div class="invalid-feedback">
              </div>
            </div>
          </div>

          <div class="mb-3">
            <label for="email">이메일</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="you@example.com" required>
            <div class="invalid-feedback">
              이메일을 입력해주세요.
            </div>
          </div>

          <div class="mb-4"></div>
          <button class="btn btn-primary btn-lg btn-block" type="submit">가입 완료</button>
        </form>
      </div>
    </div>
    <footer class="my-3 text-center text-small">
      <p class="mb-1">&copy; 2021 YD</p>
    </footer>
  </div>
</body>
</html>