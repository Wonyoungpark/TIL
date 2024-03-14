/*eslint-disable*/

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  
  let post = '강남 우동 맛집';
  let [글제목,b] = useState(['남자 코트 추천', '강남 우동 맛집','파이썬 독학']); //[글제목, 함수]
  // let [logo, setLogo] = useState('ReactBlog'); // 제목은 변경이 잘 안되서 state를 사용할 필요가 없음
  let [좋아요,좋아요변경] = useState(0);
  
  return (
    <div className="App">
      <div className="black-nav">
        <h4 style={ {color: 'red', fontSize:'16px'} }>{ post }</h4>
      </div>
      <span onClick={ ()=>{ console.log(b('여자코트')) } }>코트 변경</span>
      <div className='list'>
        <h4>{ 글제목[0] } <span onClick={ ()=>{ 좋아요변경(좋아요+1) } }>👍</span> { 좋아요 } </h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4>{ 글제목[1] }</h4>
        <p>2월 17일 발행</p>
      </div>
      <div className='list'>
        <h4>{ 글제목[2] }</h4>
        <p>2월 17일 발행</p>
      </div>
      <h4>{ post }</h4>
    </div>
  );
}

export default App;
