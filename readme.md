He agregado:
- la libreria de coneccion MySql en el paquete Library (JAR)
- Una clase MySqlConection que contiende los DATOS PARA CONECTAR A LA BDD, como: host, password, puerto, nombre_DB, 
- Un modelo User con un metodo Save() que usa a MySqlConection para insertar en la BDD un nuevo usuario, 
  (use este como prueba para no tocar el que ya habia con nombre Usuario) pueden seguir add metodos a esa clase
  para el resto del Crud. o en su defecto 
- Un controller UsuarioServletNew que usa el modelo User y guarda con los datos que llegan desde el Request
- Un controller UserIndexServelt q deberia devolver todos los user registrados para cargalos en la tabla(Aun no esta)

*Nota: en la raiz add un directorio 'assets' con el .sql para la tabla(la BDD debe llamarse Adm_Proyects), y el .JAR que es el conector
