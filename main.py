from flask import Flask

def create_app():
    #플라스크 인스턴스 생성
    app = Flask(__name__)

    # 컨트롤러 등록
    from controller import main_controller
    from controller import deeplearning_controller

    # 블루프린트 등록
    app.register_blueprint(main_controller.bp)
    app.register_blueprint(deeplearning_controller.bp)

    return app


if __name__ == '__main__':
    ### 플라스크앱 생성
    app = create_app()

    ### 플라스크앱 실행
    app.run(host='0.0.0.0', port=8888, debug=True)  # debug=True : 소스코드를 변경 자동으로 감지 Flask서버 재시작
