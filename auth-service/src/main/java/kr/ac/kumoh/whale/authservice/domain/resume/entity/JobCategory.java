package kr.ac.kumoh.whale.authservice.domain.resume.entity;

import kr.ac.kumoh.whale.authservice.global.error.exception.InvalidValueException;

public enum JobCategory {
    // 경영행정사무직
    경영행정사무직_데스크안내원("경영 행정 사무직/데스크 안내원"),
    경영행정사무직_통계설문조사원("경영 행정 사무직/통계·설문 조사원"),
    경영행정사무직_인사노무전문가("경영 행정 사무직/인사·노무 전문가"),
    경영행정사무직_전산자료입력원("경영 행정 사무직/전산자료 입력원(DB·단순자료)"),
    경영행정사무직_고객상담원("경영 행정 사무직/고객 상담원(A/S·고장·제품사용)"),
    경영행정사무직_사무보조원_공공기관("경영 행정 사무직/사무 보조원(공공기관)"),
    경영행정사무직_사무보조원_일반사업체("경영 행정 사무직/사무 보조원(일반사업체)"),
    경영행정사무직_병원행정사무원("경영 행정 사무직/병원행정 사무원(원무)"),
    경영행정사무직_총무및일반사무원("경영 행정 사무직/총무 및 일반 사무원"),
    경영행정사무직_인사사무원("경영 행정 사무직/인사 사무원"),
    경영행정사무직_경영기획사무원("경영 행정 사무직/경영 기획 사무원"),
    경영행정사무직_마케팅광고홍보상품기획사무원("경영 행정 사무직/마케팅·광고·홍보·상품기획 사무원"),
    경영행정사무직_공공행정사무원("경영 행정 사무직/공공행정 사무원"),
    경영행정사무직_물류사무원("경영 행정 사무직/물류 사무원(물류 관리사)"),
    경영행정사무직_생산품질사무원및관리원_전기전자컴퓨터("경영 행정 사무직/생산·품질사무원 및 관리원(전기·전자·컴퓨터)"),
    경영행정사무직_교육훈련사무원("경영 행정 사무직/교육·훈련 사무원"),
    경영행정사무직_생산품질사무원및관리원_음식료품("경영 행정 사무직/생산·품질사무원 및 관리원(음식료품)"),
    경영행정사무직경리사무원("경영 행정 사무직/경리 사무원(일반사업체)"),
    경영행정사무직_학교행정사무원("경영 행정 사무직/학교행정 사무원(교무)"),
    경영행정사무직_회계사무원("경영 행정 사무직/회계 사무원(일반 사업체)"),
    경영행정사무직_재무사무원("경영 행정 사무직/재무 사무원"),
    경영행정사무직_조세행정사무원("경영 행정 사무직/조세행정 사무원"),
    경영행정사무직_영업기획관리지원사무원("경영 행정 사무직/영업 기획·관리·지원 사무원"),
    경영행정사무직_국가지방행정사무원("경영 행정 사무직/국가·지방행정 사무원"),
    경영행정사무직_생산품질사무원및관리원("경영 행정 사무직/생산·품질사무원 및 관리원(그 외 분야)"),
    경영행정사무직_단순경리사무원("경영 행정 사무직/단순 경리 사무원"),
    // 운전운송직
    운전_운송직_신문_음료_기타_배달원("운전·운송직/신문·음료(우유·요구르트 등) 기타 배달원"),
    운전_운송직_일반_택배원("운전·운송직/일반 택배원(퀵서비스 포함)"),
    운전_운송직_우편물_집배원("운전·운송직/우편물 집배원"),
    운전_운송직_하역_적재_종사원("운전·운송직/하역·적재 종사원"),
    운전_운송직_경_소형_화물차_운전원("운전·운송직/경·소형 화물차 운전원"),
    운전_운송직_배송_납품_운전원("운전·운송직/배송·납품 운전원(납품영업 포함)"),
    운전_운송직_노선버스_운전원("운전·운송직/노선버스 운전원(시내, 마을, 시외, 고속)"),
    운전_운송직_승용차_운전원("운전·운송직/승용차 운전원(자가용 운전원)"),
    운전_운송직_관광_및_통근_통학_학원_및_기타_버스_운전원("운전·운송직/관광 및 통근·통학·학원 및 기타 버스 운전원"),

    // 기계_설치정비_생산직
    기계_설치정비_생산직_기계_금속분야_단순_종사원("기계 설치정비 생산직/기계·금속 분야 단순 종사원"),
    기계_설치정비_생산직_CNC_밀링기_조작원("기계 설치정비 생산직/CNC 밀링기 조작원(NC 밀링기 조작원)"),
    기계_설치정비_생산직_물펌프_정수_처리장치_조작원("기계 설치정비 생산직/물펌프·정수 처리장치 조작원"),
    기계_설치정비_생산직_펄프_종이_제조장치_조작원("기계 설치정비 생산직/펄프·종이 제조장치 조작원"),
    기계_설치정비_생산직_신발_제조기계_조작원_및_조립원("기계 설치정비 생산직/신발 제조기계 조작원 및 조립원"),
    기계_설치정비_생산직_주입_포장_상표부착기_등_기타_기계_조작원("기계 설치정비 생산직/주입·포장·상표부착기 등 기타 기계 조작원"),
    기계_설치정비_생산직_두부_및_유사제품_생산기계_조작원("기계 설치정비 생산직/두부 및 유사제품 생산기계 조작원"),
    기계_설치정비_생산직_세탁_기계_조작원("기계 설치정비 생산직/세탁 기계 조작원"),
    기계_설치정비_생산직_기타_비금속제품_생산기계_조작원("기계 설치정비 생산직/기타 비금속제품 생산기계 조작원"),
    기계_설치정비_생산직_육류_가공기계_조작원("기계 설치정비 생산직/육류 가공기계 조작원"),
    기계_설치정비_생산직_종이제품_생산기계_조작원("기계 설치정비 생산직/종이제품 생산기계 조작원"),
    기계_설치정비_생산직_자동차_부분품_조립_및_검사원("기계 설치정비 생산직/자동차 부분품 조립·검사원"),
    기계_설치정비_생산직_자동차_조립_및_검사원("기계 설치정비 생산직/자동차 조립·검사원"),
    기계_설치정비_생산직_기타_기계_조립_및_검사원("기계 설치정비 생산직/기타 기계 조립·검사원"),

    // 금속_재료_설치_정비_생산직(판금_단조_주조_용접_도장_등)
    금속_재료_설치_정비_생산직_금속기계부품_조립원("금속 재료 설치 정비 생산직/금속기계부품 조립원"),
    금속_재료_설치_정비_생산직_기타_금속공작기계_조작원_및_보조원("금속 재료 설치 정비 생산직/기타 금속공작기계 조작원 및 보조원");



    private final String displayName;

    JobCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static JobCategory findByDisplayName(String displayName) {
        for (JobCategory category : JobCategory.values()) {
            if (category.getDisplayName().equals(displayName)) {
                return category;
            }
        }
        throw new InvalidValueException("일치하는 jobCategory가 없음");
    }
}
