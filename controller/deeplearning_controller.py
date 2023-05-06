from flask import render_template, Blueprint

bp = Blueprint('deeplearning',
               __name__,
               url_prefix='/deeplearning')

deeplearnig_model_status = "딥러닝 모델이 꺼져있습니다 From 서버 > 글로벌(전역)변수"


# 요청 URL : http://127.0.0.1:8888/deeplearning/modelload
@bp.route('/modelload')
def deeplearning_model_load():
    print("modelload 컨트롤러!!!")

    print("딥러닝 모델이 켜졌습니다")

    global deeplearnig_model_status
    deeplearnig_model_status = "딥러닝 모델 켜졌습니다 From 서버 > 컨트롤러"

    return render_template('otherpage.html', deeplearnig_model_status=deeplearnig_model_status)

