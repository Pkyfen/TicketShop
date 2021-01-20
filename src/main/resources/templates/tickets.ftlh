<#import "parts/common.ftlh" as c>
<#include "parts/security.ftlh">

<@c.page>
    <h1 class="center mb-3">Мои билеты</h1>
    <div class="row">
        <#list tickets as ticket>
                <div class="col-4">
                    <div class="card" style="width: 18rem;">
                        <div class="card-body">
                            <h5 class="card-title">${ticket.getSession().getFilm().getName()}</h5>

                            <p class="card-text">Дата: ${ticket.getSession().getDate()}  </p>
                            <p class="card-text">Время: ${ticket.getSession().getTime()} </p>
                            <p class="card-text">Ряд ${ticket.getRow() + 1} Место ${ticket.getSeat() + 1}</p>
<#--                            <a href="/film/${film.id}" class="btn btn-primary">Купить билет</a>-->
<#--                            <#if isAdmin>-->
<#--                                <a href="#" class="card-link">Редактировать</a>-->
<#--                            </#if>-->
                        </div>
                    </div>
                </div>
            <#else >
            <h6>Пусто</h6>
        </#list>
    </div>
</@c.page>