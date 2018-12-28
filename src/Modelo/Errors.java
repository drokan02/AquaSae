package Modelo;

public class Errors {

  public static String errorMessage(int errorcode, String sqlexception) {
    String errorname = "";
    switch (errorcode) {
      case 1005:
        errorname = "No puedo crear tabla";
        break;
      case 1011:
        errorname = "Error en el borrado";
        break;
      case 1012:
        errorname = "No puedo leer el registro en la tabla del sistema";
        break;
      case 1020:
        errorname = "El registro ha cambiado desde la ultima lectura de la tabla";
        break;
      case 1022:
        errorname = "No puedo escribir, clave duplicada en la tabla";
        break;
      case 1032:
        errorname = "No puedo encontrar el registro";
        break;
      case 1034:
        errorname = "Clave de archivo erronea para la tabla";
        break;
      case 1035:
        errorname = "Clave de archivo antigua para la tabla '%s'; reparelo";
        break;
      case 1040:
        errorname = "Demasiadas conexiones";
        break;
      case 1042:
        errorname = "No puedo obtener el nombre de maquina de tu direccion";
        break;
      case 1043:
        errorname = "Protocolo erroneo ";
        break;
      case 1046:
        errorname = "Base de datos no seleccionada ";
        break;
      case 1047:
        errorname = "Comando desconocido";
        break;
      case 1048:
        errorname = "La columna '%s' no puede ser nula";
        break;
      case 1049:
        errorname = "Base de datos desconocida";
        break;
      case 1050:
        errorname = "La tabla '%s' ya existe";
        break;
      case 1051:
        errorname = "Tabla '%s' desconocida";
        break;
      case 1053:
        errorname = "Desconexion de servidor en proceso";
        break;
      case 1056:
        errorname = "No puedo agrupar";
        break;
      case 1057:
        errorname = "El estamento tiene funciones de suma y columnas en el mismo estamento";
        break;
      case 1058:
        errorname = "La columna con count no tiene valores para contar";
        break;
      case 1060:
        errorname = "Nombre de columna duplicado";
        break;
      case 1061:
        errorname = "Nombre de clave duplicado";
        break;
      case 1062:
        errorname = " Entrada duplicada '%s' para la clave";
        break;
      case 1063:
        errorname = "Especificador de columna erroneo para la columna '%s'";
        break;
      case 1065:
        errorname = "La query estaba vacia";
        break;
      case 1068:
        errorname = "Multiples claves primarias definidas";
        break;
      case 1069:
        errorname = "Demasiadas claves primarias declaradas.";
        break;
      case 1072:
        errorname = "La columna clave '%s' no existe en la tabla ";
        break;
      case 1090:
        errorname = "No puede borrar todos los campos con ALTER TABLE. Usa DROP TABLE para hacerlo";
        break;
      case 1091:
        errorname = "No puedo ELIMINAR '%s'. compuebe que el campo/clave existe";
        break;
      case 1104:
        errorname = "El SELECT puede examinar muchos registros y probablemente con mucho tiempo. Verifique tu WHERE y usa SET SQL_BIG_SELECTS=1 si el SELECT esta correcto";
        break;
      case 1105:
        errorname = "Error desconocido";
        break;
      case 1106:
        errorname = "Procedimiento desconocido";
        break;
      case 1107:
        errorname = " Equivocado parametro count para procedimiento %s ";
        break;
      case 1108:
        errorname = "Equivocados parametros para procedimiento";
        break;
      case 1109:
        errorname = "Tabla desconocida";
        break;
      case 1111:
        errorname = " Invalido uso de funciÃ³n en grupo";
        break;
      case 1113:
        errorname = "Una tabla debe tener al menos 1 columna";
        break;
      case 1114:
        errorname = "La tabla '%s' estÃ¡ llena ";
        break;
      case 1115:
        errorname = "Juego de caracteres desconocido:";
        break;
      case 1116:
        errorname = "Muchas tablas. MySQL solamente puede usar %d tablas en un join";
        break;
      case 1117:
        errorname = "Muchos campos";
        break;
      case 1118:
        errorname = "TamaÃ±o de lÃ­nea muy grande. MÃ¡ximo tamaÃ±o de lÃ­nea, no contando blob, es %ld. Tu tienes que cambiar algunos campos para blob";
        break;
      case 1120:
        errorname = "Dependencia cruzada encontrada en OUTER JOIN. Examine su condiciÃ³n ON";
        break;
      case 1122:
        errorname = " No puedo cargar funciÃ³n";
        break;
      case 1123:
        errorname = "No puedo inicializar funciÃ³n ";
        break;
      case 1124:
        errorname = "No pasos permitidos para librarias conjugadas";
        break;
      case 1127:
        errorname = "No puedo encontrar funciÃ³n";
        break;
      case 1128:
        errorname = "FunciÃ³n '%s' no estÃ¡ definida";
        break;
      case 1129:
        errorname = "Servidor '%s' estÃ¡ bloqueado por muchos errores de conexiÃ³n. Desbloquear con 'mysqladmin flush-hosts'";
        break;
      case 1131:
        errorname = "Tu estÃ¡s usando MySQL como un usuario anonimo y usuarios anonimos no tienen permiso para cambiar las claves";
        break;
      case 1132:
        errorname = "Tu debes de tener permiso para actualizar tablas en la base de datos mysql para cambiar las claves para otros";
        break;
      case 1133:
        errorname = "No puedo encontrar una lÃ­nea correspondiente en la tabla user ";
        break;
      case 1135:
        errorname = "No puedo crear un nuevo thread (errno %d). Si tu estÃ¡ con falta de memoria disponible, tu puedes consultar el Manual para posibles problemas con SO";
        break;
      case 1138:
        errorname = " Invalido uso de valor NULL ";
        break;
      case 1140:
        errorname = "Mezcla de columnas GROUP (MIN(),MAX(),COUNT()...) con no GROUP columnas es ilegal si no hay la clausula GROUP BY ";
        break;
      case 1141:
        errorname = "No existe permiso definido para usuario";
        break;
      case 1144:
        errorname = "Ilegal comando GRANT/REVOKE. Por favor consulte el manual para cuales permisos pueden ser usados.";
        break;
      case 1145:
        errorname = "El argumento para servidor o usuario para GRANT es demasiado grande";
        break;
      case 1146:
        errorname = "Tabla '%s.%s' no existe";
        break;
      case 1148:
        errorname = "El comando usado no es permitido con esta versiÃ³n de MySQL";
        break;
      case 1149:
        errorname = " Algo estÃ¡ equivocado en su sintax ";
        break;
      case 1157:
        errorname = "No puedo descomprimir paquetes de comunicaciÃ³n";
        break;
      case 1158:
        errorname = "Obtenido un error leyendo paquetes de comunicaciÃ³n";
        break;
      case 1159:
        errorname = "Obtenido timeout leyendo paquetes de comunicaciÃ³n ";
        break;
      case 1160:
        errorname = "Obtenido un error de escribiendo paquetes de comunicaciÃ³n";
        break;
      case 1161:
        errorname = "Obtenido timeout escribiendo paquetes de comunicaciÃ³n";
        break;
      case 1163:
        errorname = "El tipo de tabla usada no permite soporte para columnas BLOB/TEXT ";
        break;
      case 1164:
        errorname = "El tipo de tabla usada no permite soporte para columnas AUTO_INCREMENT";
        break;
      case 1166:
        errorname = "Incorrecto nombre de columna";
        break;
      case 1167:
        errorname = "El manipulador de tabla usado no puede indexar columna";
        break;
      case 1169:
        errorname = "No puedo escribir, debido al Ãºnico constraint, para tabla";
        break;
      case 1171:
        errorname = "Todas las partes de un PRIMARY KEY deben ser NOT NULL; Si necesitas NULL en una clave, use UNIQUE ";
        break;
      case 1172:
        errorname = "Resultado compuesto de mas que una lÃ­nea ";
        break;
      case 1173:
        errorname = "Este tipo de tabla necesita de una primary key";
        break;
      case 1175:
        errorname = "Tu estÃ¡s usando modo de actualizaciÃ³n segura intentado actualizar una tabla sin un WHERE que usa una KEY columna";
        break;
      case 1177:
        errorname = "No puedo abrir tabla";
        break;
      case 1180:
        errorname = "Obtenido error %d durante COMMIT";
        break;
      case 1181:
        errorname = "Obtenido error %d durante ROLLBACK";
        break;
      case 1182:
        errorname = "Obtenido error %d durante FLUSH_LOGS";
        break;
      case 1183:
        errorname = "Obtenido error %d durante CHECKPOINT";
        break;
      case 1191:
        errorname = "No puedo encontrar Ã­ndice FULLTEXT correspondiendo a la lista de columnas";
        break;
      case 1204:
        errorname = "Tu solo debes usar expresiones constantes con SET";
        break;
      case 1205:
        errorname = "Tiempo de bloqueo de espera excedido";
        break;
      case 1206:
        errorname = "El nÃºmero total de bloqueos excede el tamaÃ±o de bloqueo de la tabla ";
        break;
      case 1210:
        errorname = "Argumentos errados";
        break;
      case 1214:
        errorname = "El tipo de tabla usada no soporta Ã­ndices FULLTEXT";
        break;
      case 1215:
        errorname = "No puede adicionar clave extranjera constraint";
        break;
      case 1222:
        errorname = "El comando SELECT usado tiene diferente nÃºmero de columnas";
        break;
      case 1223:
        errorname = "No puedo ejecutar el query porque usted tiene conflicto de traba de lectura";
        break;
      case 1232:
        errorname = "Tipo de argumento equivocado para variable";
        break;
      case 1235:
        errorname = "Esta versiÃ³n de MySQL no soporta todavia";
        break;
      case 1240:
        errorname = "Referencia de llave y referencia de tabla no coinciden";
        break;
      case 1242:
        errorname = "Subconsulta retorna mas que 1 lÃ­nea";
        break;
      case 1245:
        errorname = "CÃ­clica referencia en subconsultas";
        break;
      case 1248:
        errorname = "Cada tabla derivada debe tener su propio alias";
        break;
      case 1251:
        errorname = "Cliente no soporta protocolo de autenticaciÃ³n solicitado por el servidor; considere actualizar el cliente MySQL";
        break;
      case 1317:
        errorname = "Consulta En Execucion Fue Interrumpida";
        break;
      case 1359:
        errorname = "El Trigger Ya Existe";
        break;
      case 1360:
        errorname = "El Trigger No Existe";
        break;
      case 2000:
        errorname = " El error desconocido MySQL";
        break;
      case 2002:
        errorname = "No puede conectarse al servidor local MySQL a travÃ©s de conector ";
        break;
      case 2003:
        errorname = "No puede conectarse al servidor MySQL en ";
        break;
      case 2008:
        errorname = "El cliente MySQL se quedÃ³ sin memoria";
        break;
      case 2050:
        errorname = " La fila que la recuperaciÃ³n fue cancelada por la llamada _ cercana mysql stmt ()";
        break;
      case 2052:
        errorname = "La declaraciÃ³n preparada no contiene metadatos";
        break;
      default:
        errorname = sqlexception;
        break;
    }
    return errorname;
  }
}
