from flask import render_template, Blueprint


bp = Blueprint('main',
               __name__,
               url_prefix='/main')

# 요청 URL : http://127.0.0.1:8888/main/index
@bp.route('/index')
def main():
    print("메인(인덱스) 컨트롤러!!!")

    # return "Hello Flask WebApp 메인페이지.HTML 파일(=HTML언어/문법/태그 로 구성된 표준화 된 파일) 서버로 부터 받아왔습니다."
    # return "<b>Hello Flask WebApp 메인페이지</b><hr><h2>HTML 파일(=HTML언어/문법/태그 로 구성된 표준화 된 파일) 서버로 부터 받아왔습니다.</h2>"
    return render_template('main.html')  # 이로써 뷰단(V)과 컨트롤러(C) 분리 -> MVC 패턴

# 요청 URL : http://127.0.0.1:8888/main/otherpage
@bp.route('/otherpage')
def otherpage():
    print("otherpage 컨트롤러!")

    from controller.deeplearning_controller import deeplearnig_model_status as 다른곳에서가져온딥러닝모델상태값

    return render_template('otherpage.html', deeplearnig_model_status=다른곳에서가져온딥러닝모델상태값)

