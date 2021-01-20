<#import "parts/common.ftlh" as c>

<@c.page>
    <form action="/addFilm" method="post" xmlns="http://www.w3.org/1999/html">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Название: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="name"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Описание: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="description"/>
            </div>
        </div>

        <div class="form-group row">
            <label class="col-sm-2 col-form-label"> Постер: </label>
            <div class="col-sm-6">
                <input class="form-control" type="text" name="picture"/>
            </div>
        </div>
        <div class="form-group row">
            <label for="example-date-input" class="col-2 col-form-label">Начало проката</label>
            <div class="col-sm-6">
                <input class="form-control" type="date" name="startDate">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>

        <button class="btn btn-primary" type="submit">Добавить</button>
    </form>
</@c.page>