(function () {
    //에리메세지를 띄우되 동작은 실행한다
    'use strict'

    const boardListElem = document.querySelector('#board_list');
    const dataElem = document.querySelector('#data');
    const searchParams = new URL(window.location.href).searchParams;
    const icategory = searchParams.get("icategory");
    const param = {
        'icategory': dataElem.dataset.icategory,
        'name'     : '홍길동'
    }
    const getList = () => {
        myFetch.get(`/ajax/board/${icategory}`, list => {
            console.log(list);
            makeRecodes(list);
        })
    }

    const makeRecodes = list => {
        const tbodyElem = boardListElem.querySelector('table tbody');
        list.forEach(item => {
            const tr = document.createElement("tr");
            tbodyElem.appendChild(tr);
            tr.innerHTML = `
           <td>${item.iboard}</td>
           <td>${item.title}</td>
           <td>${item.username}</td>
           <td>${item.hits}</td>
           <td>${item.rdt}</td>
           `;
        });
    }
    getList();
})()