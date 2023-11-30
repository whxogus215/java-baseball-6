## 체크 리스트

[ ] JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**  
[ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.  
[ ] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.  
[ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.  
[ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.  
[ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**  
[ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.  
[ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

[ ] 3항 연산자를 쓰지 않는다.  
[ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

[ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.  
[ ] else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

[ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

[ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

[ ] 아래 있는 `InputView`, `OutputView` 클래스를 참고하여 입출력 클래스를 구현한다.
- 입력과 출력을 담당하는 클래스를 별도로 구현한다.
- 해당 클래스의 패키지, 클래스명, 메서드의 반환 타입과 시그니처는 자유롭게 구현할 수 있다.
  ```java
  public class InputView {
      public int readDate() {
          System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
          String input = Console.readLine();    
          // ...
      }
      // ...
  }
  ```
  ```java
  public class OutputView {
      public void printMenu() {
          System.out.println("<주문 메뉴>");
          // ...
      }
      // ...
  }
  ```
  
## 기능 설계
1. Numbers
    - 컴퓨터의 숫자는 랜덤 값이어야 한다.
    - 사용자의 숫자는 입력받은 값이어야 한다.
    - 각 숫자에 0이 포함되지 않았는지 검증해야 한다.
    - 볼/스트라이크 개수를 반환하는 비즈니스 로직이 있어야 한다.
      - 스트라이크 : 각 리스트의 자릿수를 비교한다.
      - 볼 : 숫자의 포함여부와 각 자릿수가 다름을 확인한다.
2. Result
    - `Numbers`로부터 전달받은 볼/스트라이크 개수를 바탕으로 출력에 필요한 결과 값을 선택한다.
    - `OutputView`에게 전달하기 위한 DTO가 필요하다.
3. InputView
    - 콘솔창으로부터 입력받는다.
    - 컨트롤러에게 입력 값을 전달한다.
4. Controller
    - `InputView`로부터 입력받은 값이 올바른 숫자 형식인지 검증한다.
    - `Parser`에게 넘겨서 `List<Integer>` 타입의 숫자를 전달받는다.
5. Parser
    - 전달받은 문자열을 `List<Integer>` 타입으로 변환하여 반환한다.
