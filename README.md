# TRY_

Android Study 개발자를 위한 도전과제 프로젝트입니다. <BR>
우측 상단 fork를 클릭하셔서 본인의 저장소에 소스를 가져가신 다음 clone하셔서 작업하시면됩니다.<BR>
만약 <b>TRY_프로젝트<b>에 기여하고 싶으시다면 브랜치를 만드신 다음 기능을 추가하시고 PR ( Pull Request )를 해주시면 됩니다.<br>
소스 검토 후 문제가 없을 경우 병합하도록 하겠습니다.

### 패키지구조
ㄴ app - 앱 개발모듈<BR>
  [tab][space]ㄴ _0_root : 앱 첫화면, 도전과제 리스트
  [tab][space]ㄴ _1_android_base : 기본편 도전과제
  <t>ㄴ _2_camera_gallery : 카메라 & 앨범 기능 도전과제
  
ㄴ common - 공통 모듈<BR>
  <t>ㄴ callback : 콜백
  <t>ㄴ database : 내부 디비 ( sharedPreferences, room )
  <t>ㄴ http : 통신 모듈 ( retrofit )
  <t>ㄴ util : 유틸리티
  <t>ㄴ view : 뷰 관련 유틸
