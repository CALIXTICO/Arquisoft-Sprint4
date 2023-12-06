from django.db import models
import secrets

class Measurement(models.Model):
    token = models.CharField(max_length=50, default=secrets.token_urlsafe)
    nombre = models.CharField(max_length=30)
    apellido = models.CharField(max_length=30)
    rol = models.CharField(max_length=20)
    
    def __str__(self):
        return '%s %s' % (self.value, self.unit)