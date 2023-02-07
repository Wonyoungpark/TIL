# 정보 수집

## 수집할 정보
- 웹 애플리케이션을 서비스하기 위한 호스트 환경에 대한 정보 (ex. os, 웹 서버, 웹 프레임워크)
- 웹 애플리케이션 자체에 대한 정보

## 수집 방법
1. 배너를 통한 정보 수집
    - Banner Grabbing
    - 응답 메시지의 서버 헤더를 통해 수집
2. 기본 설치 파일을 통한 시스템 정보 수집
    - 웹 애플리케이션을 운영하기 위한 구성 요소 설치 시 기본으로 설치되는 파일로 인해 호스트 환경에 대한 정보 노출
3. 웹 취약점 스캐닝
    - 자동화된 프로그램으로 웹 사이트 정보 수집 및 취약점 파악
    - 단점 : 많은 트래픽 유발
    - 스캐닝 프로그램 : nikto

    <pre><code> (kali㉿kali)-[~]
    └─$ nikto -host IP_ADDRESS
    - Nikto v2.1.6
    ---------------------------------------------------------------------------
    + Target IP:          IP_ADDRESS
    + Target Hostname:    IP_ADDRESS
    + Target Port:        PORT_NUM
    + Start Time:         2022-07-02 02:42:46 (GMT-4)
    ---------------------------------------------------------------------------
    + Server: Apache/2.2.8 
   ...
    ---------------------------------------------------------------------------
    + 1 host(s) tested </code></pre>
4. 디렉터리 인덱싱
    - 웹 서버의 잘못된 설정으로 웹 서버 디렉터리의 파일들이 노출되는 취약점
    - 디렉터리 리스팅 취약점
5. 웹 애플리케이션 매핑
    - 웹 애플리케이션의 메뉴와 링크를 따라가면서 어떤 URL과 파라미터들이 전송되는지 웹 애플리케이션의 구조를 파악하는 과정
    - 수동 매핑
        - 직접 웹 애플리케이션에 접속하여 각 메뉴를 확인하는 과정
        - Burp Suite
    - 크롤링
        - 웹 페이지 링크를 분석해 새로운 웹 페이지를 찾아내는 과정
        - 버프 스위트의 스파이더 기능
    - DirBuster : URL 자동 입력
6. robots.txt
    - 웹 로봇
    - robots.txt를 웹사이트의 가장 상위 디렉터리에 위치시켜, 해당 사이트의 정보 수집 허용/불허 명령을 내릴 수 있음
    - 중요한 경로가 노출될 수 있는 단점

## 정보 수집 대응 방법
- 불필요한 정보 노출 삭제 : 서버 헤더에 제공된 정보 삭제하여 전송
- 스캐너/크롤러 차단 : by 로깅 & 모니터링
- 디렉터리 인덱싱 설정 제거 : 웹 서버의 설정 변경