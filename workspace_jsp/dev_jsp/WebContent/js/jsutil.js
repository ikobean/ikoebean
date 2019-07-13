function replaceText(el,text){
	if(el!=null){
		//기존 노드에 들어있는 값은 초기화
		clearText(el);
		//새로운 텍스트 노드를 추가
		var newNode = document.createTextNode(text);//12
		el.appendChild(newNode);
	}
}
//파라미터로 넘어온 태그에 값을 지운다.
function clearText(el){
	if(el!=null){
		if(el.childNodes){//js는 0만 false
			for(var i=0; i<el.childNodes.length;i++){ //nodes : 배열. 자식노드들이 더 있을 수 있으니까 for문 사용
				var childNodes = el.childNodes[i];
				el.removeChild(childNodes);

			}
		}
	}
}
//텍스트노드의 값을 읽어오는 메소드
//@param-노드 주소번지

function getText(el){//el =>$("#id")
	var text="";
	if(el!=null){//태그가 존재하지 않으면 
		if(el.childNodes){//태그 안에 여러개 노드가 있으면 컬렉션으로 브라우저가 담음.==>자동으로 배열이 됨.
			for(var i=0; i<el.childNodes.length;i++){
				//여러개 노드 중 한개에 해당하는 게 childNode (700000)
				var childNode = el.childNodes[i]; //그래서 배열 기호[]로 접근 가능
				//너 텍스트 노드니?
				if(childNode.nodeName!=null){//700000!=null 노드값 읽어오기
					text=text+childNode.nodeValue;
				}			
			}
		}
	}
	return text; //js는 리턴값이 없지만 변수에 담아서 이렇게 활용할 수 있음.
}

