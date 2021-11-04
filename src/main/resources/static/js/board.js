let index = {
	init: function() {
		$('#btn-save').on('click', () => {
			// function(){}, ()=>{} this를 바인딩하기 위해서 사용
			this.save();
		});
		$('#btn-delete').on('click', () => {
			// function(){}, ()=>{} this를 바인딩하기 위해서 사용
			this.deleteById();
		});
		$('#btn-update').on('click', () => {
			// function(){}, ()=>{} this를 바인딩하기 위해서 사용
			this.update();
		});
		$('#btn-reply-save').on('click', () => {
			this.replySave();
		});
	},

	save: function() {
		let data = {
			title: $('#title').val(),
			content: $('#content').val(),
		};
		// console.log(data);

		// ajax호출시 default가 비동기 호출
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 오브젝트로 변환
		$.ajax({
			type: 'POST',
			url: '/api/board',
			data: JSON.stringify(data), // http body 데이터
			contentType: 'application/json; charset=utf-8', // body데이터가 어떤 타입인지(MIME)
			dataType: 'json', // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
		})
			.done(function(resp) {
				alert('글쓰기가 완료되었습니다.');
				location.href = '/';
			})
			.fail(function(error) {
				alert(JSON.stringify(error));
			});
	},
	deleteById: function() {
		let id = $('#id').text();
		$.ajax({
			type: 'DELETE',
			url: '/api/board/' + id,
			dataType: 'json', // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
		})
			.done(function(resp) {
				alert('삭제가 완료되었습니다.');
				location.href = '/';
			})
			.fail(function(error) {
				alert(JSON.stringify(error));
			});
	},
	update: function() {
		let id = $('#id').val();
		let data = {
			title: $('#title').val(),
			content: $('#content').val(),
		};
		$.ajax({
			type: 'PUT',
			url: '/api/board/' + id,
			data: JSON.stringify(data), // http body 데이터
			contentType: 'application/json; charset=utf-8', // body데이터가 어떤 타입인지(MIME)
			dataType: 'json', // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
		})
			.done(function(resp) {
				alert('글수정이 완료되었습니다.');
				location.href = '/';
			})
			.fail(function(error) {
				alert(JSON.stringify(error));
			});
	},
	replySave: function() {
		let data = {
			content: $('#reply-content').val(),
		};
		
		let boardId = $('#boardId').val();
		
		$.ajax({
			type: 'POST',
			url: `/api/board/${boardId}/reply`,
			data: JSON.stringify(data), // http body 데이터
			contentType: 'application/json; charset=utf-8', // body데이터가 어떤 타입인지(MIME)
			dataType: 'json', // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게 json이라면) => javascript오브젝트로 변경
		})
			.done(function(resp) {
				alert('댓글작성이 완료되었습니다.');
				location.href = `/board/${boardId}`;
			})
			.fail(function(error) {
				alert(JSON.stringify(error));
			});
	},
	
};

index.init();
