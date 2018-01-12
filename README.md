# DoctorSupporter+


Aplikacja mobilna na platformę Android, `mająca wspierać codzienną pracę lekarzy poprzez wyeliminowanie bariery fizycznej dostępu do danych pacjentów` tj. informacji o przebytych chorobach, nadwrażliwościach, alergiach, podanych lekach czy przeprowadzonych badaniach poprzez umożliwienie dostępu do tychże za pośrednictwem tabletu w który ma zostać wyposażony lekarz podczas swojej pracy. Funkcjonalnościami dotyczącymi bezpośrednio lekarza są: dostęp do kalendarza, notatnika, powiadomień czy czasu pracy. 
Docelowym urządzeniem na którym będzie działać aplikacja jest tablet.

## Documentation

To find out how to use this library follow [Documentation](https://www.youtube.com/watch?v=dQw4w9WgXcQ).

### Pogląd aplikacji


![image](https://user-images.githubusercontent.com/11943355/34871903-7ba9d288-f78f-11e7-8d4b-b432e81877f7.png)

![image](https://user-images.githubusercontent.com/11943355/34871975-a0b47060-f78f-11e7-8773-98b593873570.png)

![image](https://user-images.githubusercontent.com/11943355/34871981-a86ecb70-f78f-11e7-9ac7-120ae4f6fb3d.png)

![image](https://user-images.githubusercontent.com/11943355/34871995-b1028e84-f78f-11e7-920d-d0b9aeaf7fcd.png)

![image](https://user-images.githubusercontent.com/11943355/34872022-c4369982-f78f-11e7-9366-df59980267b9.png)

### api
```javascript
router.post('/getChoroby',function(req,res,next){
  var idPacjent = req.body.idPacjent;
  Doctors.getChoroby(idPacjent,function(err,rows){
                if(err){
            res.json(err);
        }
        else {
            res.json(rows);
        }
  })
});
```

### Doctors js
```javascript

        getChoroby:function(idPacjent,callback){
            return db.query("Select * from Choroby where Pacjent_idPacjent = ?",[idPacjent],callback);
        },
        ```

## Features (CRUD)

* create
* read
* update
* delete
* kalendarz, notatnik, czas pracy


## Guest Log In
```
login: nowakpiotr
hasło: 1234
```
