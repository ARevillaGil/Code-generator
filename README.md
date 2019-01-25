# Code-generator

La aplicación consiste en la creación y asignación de códigos de promoción para cada uno de los usuarios. 

Cada usuario podrá crear su usuario introduciendo un nombre de usuario único y una contraseña con la que acceder a la aplicación. Tanto para el registro de usuario como para el login a la aplicación solo se ha tenido en cuenta la validación del nombre de usuario único.

Una vez el usuario acceda a su cuenta, podrá generar un código de promoción único y asociado a su cuenta o ver los códigos creados con anterioridad. Cada código de usuario estará asociado únicamente a un usuario y no podrá estar repetido.

Si el usuario accede a la opción de ver sus códigos, dispondrá de un listado de todos sus códigos junto a su estado, false si aún no lo ha utilizado y true si ya lo ha utilizado. En la lista, junto al código, tendrá un botón con el que usar el código. El botón de usar código lo único que hará será cambiar el estado del código de false a true, en caso de que no hubiese sido utilizdo anteriormente.

El código de la aplicación está estructurado por un lado por la gestión de los usuarios, tanto su registro como su acceso a la aplicación, y por otro, la gestión de los códigos. Para ambos ha sido necesaria la creación de unos controladores para la gestión de la interfaz de la alicación; una capa de servicio encargada del procesamiento de datos y la comunicación con los repositorios; una capa de repositorios para la comunicación con la base de datos y una capa de modelo con las entidades de la aplicación (usuario y código).
