# 📒 solmi's diary


---

## Diary.java
**목록 번호, 날짜, 제목, 내용, 공개/비공개 기능을 구현할 수 있도록 해당 필드와 getter, setter를 만들었다.**
-   private String date;
-   private String title;
-   private String content;
-   private String access;
-   private int no;

## DiaryExample.java
**main class로 DairyService class 객체를 생성하여 showMenu() 메소드를 통해 프로그램을 실행한다.**


## DiaryExample.java
- showMenu()
  - while문과 switch문, scanner를 통해 메뉴를 선택, 입력 받는다.  
- write();
  - scanner, BufferedReader를 통해 날짜, 제목, 내용, 공개권한을 입력받아 setter에 저장. Diary 객체를 구현한다.
  - ArrayList를 사용. Diary 객체를 저장.
- showList();
  - for-each문을 통해 목록 번호, 날짜, 제목을 보여준다.
- showContent();
  - 날짜를 입력하면 해당 일기의 내용을 포함하여 보여 줌.
  - 공개권한이 비공개이면 비공개 일기라고 출력
- modify();
  - 날짜, 제목, 내용을 수정할 수 있음.
- remove();
  - list.remove()를 통해 객체 삭제
- save();
  -  DataOutputStream, FileOutputStream를 사용하여 파일로 내보냄.
  -  파일명은 제목.txt로 저장됨.

## 후기
혼자 공부하는 자바라는 책을 완독했다.<br/>
맨 마지막 페이지에 정답 없이 콘솔로 게시판을 만들어보라는 문제가 있었다.<br/>
내가 좋아하는 걸 담고 싶었다.<br/>
'내가 좋아하는 것 + 게시판'<br/>
처음엔 NCT가 떠올랐다. 나무 위키처럼NCT127, NCT Dream, NCT U에 대한 내용을 등록, 편집 할 수 있는 게시판을 만들까 생각했다.<br/>
두번째 아이디어는 블로그였다. 요즘 블로그에 일기를 포스팅하는 일에 빠져있기 때문이다.<br/>
고민하다 콘솔 일기장이라는 단어가 끌려서 후자로 선택했다.<br/>
정말 정말 정말 작은 프로젝트였지만 객체지향, try-catch문, list, output/inputStream에 대한 내용을 확실하게 이해하게 된 것 같아서 뿌듯하다.<br/>
또 프로그램에 어떤 내용을 담을까 처음부터 끝까지 직접 골라 넣은 건 처음이라 재미있었다ㅎ.ㅎ
