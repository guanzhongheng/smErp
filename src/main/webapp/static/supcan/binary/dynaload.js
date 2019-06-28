//区分浏览器：Firefox / Chrome(34 or later) / IE(X86/X64) / 国产浏览器...
function NewBrowserObj()
{
    var obj = new Object();
    obj.npapi = false;  //是否已安装 npapi
    obj.ppapi = false;  //是否已安装 ppapi
    obj.chrome_install_apitype = "";   //如果Chrome插件未安装, 允许安装的类型 (npapi, ppapi)
    obj.version = 0;
    var sver = "";
    var agnt = navigator.userAgent.toLowerCase();
    if(agnt.indexOf("edge")>0)  //edge浏览器
        obj.type = "edge";
    else if(agnt.indexOf("msie")>0 || agnt.indexOf("trident")>0) {  //ie浏览器
        obj.type = "ie";
        var off = agnt.indexOf("msie");
        if(off >= 0) sver = agnt.substring(off + 4);
    }
    else {  //chrome 或 firefox 浏览器
        if(navigator.mimeTypes["application/supcan-plugin"])  obj.npapi = true;  //npapi已经安装
        if(navigator.mimeTypes["application/x-ppapi-supcan"]) obj.ppapi = true;  //ppapi已经安装
        if(agnt.indexOf("chrome")>0) {
            obj.type = "chrome";
            var off = agnt.indexOf("chrome/");
            if(off >= 0) sver = agnt.substring(off + 7);
        }
        else
            obj.type = "firefox";
    }

    if(sver != "") {
        var off = sver.indexOf(".");
        if(off > 0) obj.version = parseInt(sver.substr(0, off));
    }

    if(obj.type == "chrome") {
        if(obj.npapi == false && obj.ppapi == false) {  //未安装插件
            if(obj.version <35 || navigator.mimeTypes.length > 15)  //老版本的 Chrome、或国产浏览器
                obj.chrome_install_apitype = "npapi";
            else
                obj.chrome_install_apitype = "ppapi";
        }
        else if(obj.npapi && obj.ppapi) { //2 种都安装了, 为了兼容, 35版前仍使用 npapi (ppapi也是支持的)
            if(obj.version <35)
                obj.ppapi = false;
            else
                obj.npapi = false;
        }
    }
    obj.is64 = (agnt.indexOf("win64")>=0 || agnt.indexOf("x64")>=0) ? true : false;
    return obj;
}

//浏览器对象(全局对象)
var $B = NewBrowserObj();

//让 ppapi 语法兼容 npapi：为 <object> 添加 func( ) 函数
if($B.ppapi) {
    Object.prototype.func = function(funcname, para) {
        return this.postMessageAndAwaitResponse([funcname, para]);
    }
}

//private:
function bldStr(ctlType, id, para, height)
{
    var ctlver = '1.0.114.0';

    //取得组件包的绝对路径(假设和dynaload.js部署在同一个目录)
    var SupcanPath="", arrScript = document.getElementsByTagName("script");
    for(var i=0; i<arrScript.length; i++) {
        var src = arrScript[i].src;
        var index = src.indexOf('dynaload.js');
        if(index >= 0) {
            SupcanPath = src.substring(0, index);
            if(SupcanPath.charAt(0) == '/') {
                src = location.href;
                index = src.indexOf('//');
                if(index != -1) {
                    index = src.indexOf('/', index+2);
                    if(index != -1) src = src.substring(0, index);
                    SupcanPath = src + SupcanPath;
                }
            }
            break;
        }
    }

    var typeid;
    if($B.type == "ie") {
        if($B.is64)
            typeid = 'CLASSID="clsid:11249C26-4BCD-4A74-B4D9-068936D77EFE" Codebase="' +SupcanPath+ 'supcan2.x64.cab#Version=1,0,0,3"';
        else
            typeid = 'CLASSID="clsid:619F1AC0-2644-40D3-9EB1-22F81C5FE097" Codebase="' +SupcanPath+ 'supcan2.cab#Version=1,0,0,3"';
    }
    else {
        if($B.npapi) typeid = 'type="application/supcan-plugin"';
        if($B.ppapi) typeid = 'type="application/x-ppapi-supcan"';
        if($B.type == "firefox") typeid += ' Codebase="' +SupcanPath+ 'supcan.xpi"';
    }

    //组件包URL
    var zipurl = SupcanPath + ($B.is64 ? "BCV1.x64.bin" : "BCV1.bin");
    if(ctlType=="LuxForm")
        zipurl += "," +SupcanPath+ ($B.is64 ? "LuxForm.x64.bin" : "LuxForm.bin");
    else if(ctlType.indexOf("BCV4")>=0)
        zipurl += "," +SupcanPath+ ($B.is64 ? "BCV4.x64.bin" : "BCV4.bin");

    //End
    var str = '<Object id=' +id+ ' Width=100% height=' +height+ ' ' +typeid+ '>';
    str += '<param Name="CtlName" Value="' +ctlType+ '">';
    str += '<param Name="CtlVersion" Value="' +ctlver+ '">';
    str += '<param Name="ZipUrl" Value="' +zipurl+ '">';
    str += '<param Name="id" Value="' +id+ '">';
    str += '<param Name="Cookie" Value="' +document.cookie+ '">';
    str += '<param Name="CtlPara" Value="' +para+ '">';
    if($B.ppapi) str += '<param Name="core" Value="pure"><param Name="Locate" value="' +window.location.href+ '">';
    str += '</Object>';
    if($B.ppapi) { //为 ppapi 添加事件侦听函数, 在其中直接调用 OnReady、OnEvent, 达到语法和 npapi 兼容的目的
        str += '\n<script>\n' + id + '.addEventListener("message", handleMessage' +id+ ', false);\n'
        str += 'function handleMessage' + id + '(message) {\n if(message.data.name=="OnReady") OnReady("' +id+ '");\n else if(message.data.name=="OnEvent") OnEvent("' +id+ '", message.data.event, message.data.p1, message.data.p2, message.data.p3, message.data.p4); \n }\n</script>';
    }
    //alert(str);
    return str;
}

//public:
function insertTreeList(id, para)		{ document.write( bldStr("BCV1.TreeList",		id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertEdit(id, para)		{ document.write( bldStr("BCV1.Edit",		id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertReport(id, para)		{ document.write( bldStr("LuxForm",		id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertTree(id, para)		{ document.write( bldStr("BCV1.Tree",		id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertFreeForm(id, para)	{ document.write( bldStr("BCV1.FreeForm",	id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertChart(id, para)		{ document.write( bldStr("BCV1.Chart",		id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertUpload(id, para)		{ document.write( bldStr("BCV1.Upload",		id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertFormDesigner(id, para)	{ document.write( bldStr("BCV4.FormDesigner",	id, para, (arguments.length > 2) ? arguments[2]:"100%") )}
function insertEchart(id, para)   { document.write( bldStr("BCV1.Echart",   id, para, (arguments.length > 2) ? arguments[2]:"100%") )}

//必需的函数(控件会反向调用，用途:切换焦点)
function focusIE(obj_or_id)
{
    if($B.type != "ie") {
        document.activeElement.blur();
        return;
    }
    try {
        if(typeof(obj_or_id)=='object') {
            if(document.activeElement != obj_or_id) obj_or_id.focus();
        }
        else {
            if(document.activeElement.id == obj_or_id) return;
            var o = document.getElementById(obj_or_id);
            if(o != null) o.focus();
        }
    }
    catch(e) {
    }
}