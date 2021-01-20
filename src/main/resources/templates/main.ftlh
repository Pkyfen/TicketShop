<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h1 class="center mb-3">Сегодня в кино</h1>
    <div class="row">
    <#list films as film>
        <div class="col-4">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="${film.picture}" alt="Card image cap">
                <div class="card-body">
                    <h5 class="card-title">${film.name}</h5>
                    <p class="card-text">${film.description}</p>
                    <a href="/film/${film.id}" class="btn btn-primary">Купить билет</a>
                    <#if isAdmin>
                        <a href="#" class="card-link">Редактировать</a>
                    </#if>
                </div>
            </div>
        </div>
    </#list>
    </div>
</@c.page>
