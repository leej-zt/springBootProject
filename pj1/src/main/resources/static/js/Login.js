$(document).ready(function(){
   $(".messageBox").hide();

  // ログインボタンクリック時
  $(document).on('click', '#loginButton', function(){
    $(".messageBox").hide();

    var check = inputCheck();
    if(!check) {
      $(".messageBox").show();
      return false;
    }

      // ログイン処理
      $.ajax({
          url: "/login",
          type: "POST",
          data: $("#login_form").serialize()
      // 正常終了
      }).done(function (data, textStatus, jqXHR) {
        var result = $(data).find("#result").text();

        // ログインを失敗した場合
        if (result === "fail") {
          $("#loginError").text("ID,パスワードを確認してください。");
          $(".messageBox").show();
        // TOP画面へ遷移
        } else {
          location.href = "/top";
        }

      // 異常終了
      }).fail(function (jqXHR, textStatus, errorThrown) {
        alert(textStatus + jqXHR);
      });
  });
});

// 入力チェック
function inputCheck() {
  var id = $("#userId").val();
  var pw = $("#password").val();

  if (id === undefined || id === "") {
    $("#loginError").text("未入力項目があります。");
    return false;
  }

  if (pw === undefined || pw === "") {
    $("#loginError").text("未入力項目があります。");
    return false;
  }

  return true;
}