from django.db import models

class Doctor(models.Model):
    nombre = models.CharField(max_length=50)
    #documento = models.IntegerField(null=False, default=None)
    especialidad = models.CharField(max_length=50)
    cuentaBancaria = models.IntegerField(null=False, default=None)

    def __str__(self):
        return '%s %s' % (self.nombre, self.documento, self.especialidad)

class Token(models.Model):
    token = models.CharField(max_length=50)
    
    def _str_(self):
        return '{}'.format(self.token)