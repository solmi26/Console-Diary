import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DiaryService {
    private List<Diary> list = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    int no;

    public void showMenu() throws Exception {
        while (true) {
            System.out.println("\t\t\t\tSolmi's Console Diary");
            System.out.println(
                    "--------------------------------------------------------------------------------------------");
            System.out.println("1.일기 쓰기 | 2.목록 보기 | 3.내용 보기 | 4.수정하기 | 5.삭제하기 | 6.파일로 저장 | 7.종료");
            System.out.println(
                    "--------------------------------------------------------------------------------------------");

            System.out.print("원하는 메뉴의 번호를 입력해주세요: ");
            String selectNo = scanner.nextLine();
            switch (selectNo) {
                case "1":
                    write();
                    break;
                case "2":
                    showList();
                    break;
                case "3":
                    showContent();
                    break;
                case "4":
                    modify();
                    break;
                case "5":
                    remove();
                    break;
                case "6":
                    save();
                    break;
                case "7":
                    System.out.println("콘솔 일기장을 종료합니다.");
                    return;
            }
        }
    }

    public void write() {

        Diary diary = new Diary();
        diary.setNo(++no);

        try {
            System.out.println("날짜를 입력해주세요.");
            System.out.println("Year-Month-Day");
            diary.setDate(scanner.nextLine());
            // System.out.println(diary.getDate());

            System.out.print("제목: ");
            diary.setTitle(scanner.nextLine());

            String content = "제목: " + diary.getTitle();
            System.out.print(" 내용(입력 종료는 q):");
            while (true) {
                String buffer = scanner.nextLine();
                if (buffer.equals("q"))
                    break;
                content += "\n" + buffer;

            }
            diary.setContent(content);
            // System.out.println(diary.getContent());

            System.out.print("공개(Y/N): ");
            String selectAccess = scanner.next();
            switch (selectAccess) {
                case "Y":
                case "y":
                    diary.setAccess("공개");
                    break;
                case "N":
                case "n":
                    diary.setAccess("비공개");
                    break;
            }
            list.add(diary);

        } catch (Exception e) {
            System.err.println("등록 에러:" + e);
        }

    }

    public void showList() {
        try {
            for (Diary d : list) {
                System.out.println(d.getNo() + ". " + d.getDate() + " " + d.getTitle());
            }

        } catch (Exception e) {
            System.err.println("에러메세지를 확인해주세요: " + e);
        }

    }

    public void showContent() {
        try {
            for (Diary d : list) {
                System.out.println(d.getNo() + ". " + d.getDate());
            }
            System.out.println("내용을 확인 할 일기의 날짜를 입력해주세요.");
            System.out.println("Year-Month-Day");
            String check = scanner.nextLine();
            int counter = 0;
            for (Diary d : list) {
                if (d.getDate().equals(check)) {
                    counter++;
                    if (d.getAccess().equals("비공개")) {
                        System.out.println("열람하실 수 없습니다.");
                    } else {
                        System.out.println(d.getContent());
                    }

                }
            }
            if (counter == 0) {
                System.out.println("해당 날짜의 일기가 없습니다.");
            }

        } catch (Exception e) {
            System.err.println("에러메세지를 확인해주세요: " + e);
        }

    }

    public void modify() {
        try {
            for (Diary d : list) {
                System.out.println(d.getNo() + ". " + d.getDate());
            }
            System.out.println("수정 할 일기의 날짜를 입력해주세요.");
            System.out.println("Year-Month-Day");
            String modifyData = scanner.nextLine();
            for (Diary d : list) {
                if (d.getDate().equals(modifyData)) {
                    while (true) {
                        System.out.println("1.날짜 | 2.제목 | 3.내용 | 4.공개/비공개 | 5.취소");
                        System.out.print("수정할 항목의 번호를 선택해 주세요: ");
                        String selectNo = scanner.nextLine();
                        switch (selectNo) {
                            case "1":
                                System.out.println("날짜를 입력해주세요.");
                                System.out.println("Year-Month-Day");
                                d.setDate(scanner.nextLine());
                                break;
                            case "2":
                                System.out.print("제목: ");
                                d.setTitle(scanner.nextLine());
                                break;
                            case "3":
                                String content = "제목: " + d.getTitle();
                                System.out.print(" 내용(입력 종료는 q):");
                                while (true) {
                                    String buffer = scanner.nextLine();
                                    if (buffer.equals("q"))
                                        break;
                                    content += "\n" + buffer;

                                }
                                d.setContent(content);
                                break;
                            case "4":
                                System.out.print("공개(Y/N): ");
                                String selectAccess = scanner.next();
                                switch (selectAccess) {
                                    case "Y":
                                    case "y":
                                        d.setAccess("공개");
                                        break;
                                    case "N":
                                    case "n":
                                        d.setAccess("비공개");
                                        break;
                                }
                                break;
                            case "5":
                                return;

                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("수정 오류: " + e);
        }

    }

    public void remove() {
        try {
            for (Diary d : list) {
                System.out.println(d.getNo() + ". " + d.getDate());
            }
            System.out.print("삭제 할 일기의 번호를 입력해주세요: ");
            int removeData = scanner.nextInt();
            list.remove(removeData - 1);

        } catch (Exception e) {
            System.err.println("삭제 중 오류: " + e);
        }

    }

    public void save() throws IOException {

        try {
            for (Diary d : list) {
                System.out.println(d.getNo() + ". " + d.getDate());
            }
            System.out.println("저장 할 일기날짜를 입력해주세요.");
            System.out.println("Year-Month-Day");
            String saveDate = scanner.nextLine();
            for (Diary d : list) {
                if (d.getDate().equals(saveDate)) {
                    if (d.getAccess().equals("비공개")) {
                        System.out.println("비공개 게시물입니다. 저장하실 수 없습니다.");
                    } else {
                        String saveTitle = d.getTitle();
                        DataOutputStream out = new DataOutputStream(
                                new BufferedOutputStream(new FileOutputStream(saveTitle + ".txt")));
                        out.writeUTF(d.getDate());
                        out.writeUTF(d.getTitle());
                        out.writeUTF(d.getContent());

                        out.flush();
                        out.close();
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("파일 저장에 실패했습니다." + e);
        }

    }

}
