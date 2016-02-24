set cp=WebContent\WEB-INF\lib\ejb3-persistence.jar;WebContent\WEB-INF\lib\connector-api.jar;build\classes\

wsgen -cp %cp% com.gazoomobile.mfw.platform.web.impl.UserWebServiceImpl -s src -d build\classes
wsgen -cp %cp% com.gazoomobile.mfw.platform.web.impl.ApplicationWebServiceImpl -s src -d build\classes
wsgen -cp %cp% com.gazoomobile.mfw.platform.web.impl.ControlWebServiceImpl -s src -d build\classes
wsgen -cp %cp% com.gazoomobile.mfw.platform.web.impl.DatasourceWebServiceImpl -s src -d build\classes
wsgen -cp %cp% com.gazoomobile.mfw.platform.web.impl.ConnectorWebServiceImpl -s src -d build\classes