# BoardProject
게시판 프로젝트입니다.

BoardProject는 게시판 시스템으로, 세 가지 독립적인 서비스로 구성됩니다.
- **Board**: 게시글 관리
- **Comment**: 댓글 관리
- **NestedComment**: 대댓글 관리
기획 상, 댓글의 Depth는 최대 2단계까지만 허용되므로 일반 댓글(Comment)과 대댓글(NestedComment)을 별도로 구분하여 관리합니다.

### 아키텍처 설계
본 프로젝트는 전형적인 계층형 아키텍처를 따르며, 다음과 같은 계층 구조를 가집니다.

**Controller -> Service -> Repository**
- Controller Layer: 클라이언트 요청을 받아 Service로 전달
- Service Layer: 핵심 비즈니스 로직 처리
- Repository Layer: 데이터베이스와 직접적인 연동 및 CRUD 처리

### Usecase Layer 도입
서비스 간 연관된 데이터를 삭제할 때, 상위 **Service가** 하위 **Repository를** 직접 참조해야 하는 경우가 발생할 수 있습니다.
이는 계층 간 의존성을 무너뜨릴 위험이 있어, 이를 해결하기 위해 **Usecase Layer**를 도입하였습니다.
- Usecase Layer는 서로 다른 Repository 간의 조합 및 특정 유즈케이스 처리 로직을 담당하며, 이를 통해 Service와 Repository 간의 명확한 계층 구분을 유지합니다.

### 현재 구현 상태 및 향후 계획
- 현재 Repository 구현체는 메모리 기반(In-Memory)으로 동작하도록 구성되어 있습니다.
- 향후 JPA를 활용한 구현체를 추가하여 데이터베이스와 연동할 예정입니다.
