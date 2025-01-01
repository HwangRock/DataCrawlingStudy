import requests
from bs4 import BeautifulSoup

url = "http://127.0.0.1:5500/week1_%EC%9B%B9%ED%81%AC%EB%A1%A4%EB%A7%81%EA%B3%BC%EC%A0%95%EA%B7%9C%ED%91%9C%ED%98%84%EC%8B%9D/problem/problem1.html"
response = requests.get(url) # url에서 HTML 파일을 가져옴.

soup=BeautifulSoup(response.text, 'html.parser') # BeautifulSoup을 사용해서 HTML 파일에서 파싱해서 DOM 트리 형성

title=soup.title.text # <title> 태그의 내용을 가져옴.
header=soup.find("h1").text # <h1> 태그를 찾아내서 해당 태그의 내용을 가져옴.
link=soup.find("a")["href"]  # <a> 태그의 "href" 속성을 가져옴.

print(title)
print(header)
print(link)