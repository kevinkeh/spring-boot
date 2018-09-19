<#--
    树形菜单，使用方式
    ftl中引入 <#import "/include/treeMenu.ftl" as menu/>
    <@menu.treeMenu menus/>   其中menus为后台写的菜单对象
    Menu实体见后台Menu对象 com.kevin.web.user.Menu
-->


<#macro treeMenu menuList>
    <#if menuList?? && menuList?size gt 0>
        <#list menuList as menu>
            <#if menu.hasLeaf && menu.sonList?? && menu.sonList?size gt 0>
                 <li class="treeview">
                     <a href="javascript:void(0)"><i class="${menu.menuClass}"></i>
                         <span>${menu.menuName}</span>
                         <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                         </span>
                     </a>
                     <ul class="treeview-menu">
                         <@treeMenu menuList = menu.sonList/>
                     </ul>
                 </li>
            <#else>
                <li>
                    <a href="#${menu.menuUrl}"><i class="${menu.menuClass}"></i> <span>${menu.menuName}</span></a>
                </li>
            </#if>
        </#list>
    </#if>
</#macro>