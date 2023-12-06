from django.urls import path
from django.conf.urls import url, include
from django.views.decorators.csrf import csrf_exempt

from . import views

urlpatterns = [
    url(r'^doctores/', views.DoctorList, name='doctorList'),
    url(r'^doctorcreate/$', csrf_exempt(views.DoctorCreate), name='doctorCreate'),
    url(r'^dtokencreate/$', csrf_exempt(views.TokenCreate), name='dTokenCreate'),
]