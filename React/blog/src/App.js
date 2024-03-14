/*eslint-disable*/

import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() { //component
  
  let post = '강남 우동 맛집';
  let [글제목,글제목변경] = useState(['남자 코트 추천', '강남 우동 맛집','파이썬 독학']); //[글제목, 함수]
  // let [logo, setLogo] = useState('ReactBlog'); // 제목은 변경이 잘 안되서 state를 사용할 필요가 없음
  let [좋아요,좋아요변경] = useState(0);
  
  function 정렬(){
    let copy2 = [...글제목];
    글제목 = copy2.sort();
    글제목변경(글제목);
  }

  return (
    <div className="App">
      <div className="black-nav">
        <h4 style={ {color: 'red', fontSize:'16px'} }>{ post }</h4>
      </div>

      <button onClick={ 정렬 }>가나다순 정렬</button> <t></t>

      <button onClick={ ()=>{
        // 글제목[0] = '여자코트 추천'; //원본데이터 수정
        let copy = [...글제목];
        copy[0] = '여자코트 추천';
        글제목변경(글제목);
        } }>코트 변경</button>
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

      <Modal></Modal>
      {/* <Modal/> */}

    </div>
  );
}

// const Modal = () => {
//   return(
//     <div></div>
//   )
// }

// component
function Modal(){
  return (
    <>
      <div className='modal'>
        <h4>제목</h4>
        <p>날짜</p>
        <p>상세내용</p>
      </div>
      <div></div>
    </>
  );
}

export default App;
