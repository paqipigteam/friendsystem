/**
 * @author PQ
 * @Description 描述
 * @Date 19:15 20/3/2020
 * @version 3.4.14
**/
function selectAllUser(list) {
    for(var i=0;i<list.length;i++){
        var info = `
                <tr>
                    <td>${list[i].userId}</td>
                    <td>${list[i].account}</td>
                    <td>${list[i].status==0?"被禁用":"已激活"}</td>
                    <td><button class="button" onclick="changeUserStatus(data,function (boolean)">${list[i].status==0?"激活":"禁用"}</button></td>
                </tr>
        `
        $("#tbody").append(info)

    }
}