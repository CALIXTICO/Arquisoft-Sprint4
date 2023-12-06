from django.urls import path
from django.conf.urls import url, include
from django.views.decorators.csrf import csrf_exempt

from . import views

urlpatterns = [
    url(r'^tokens/', views.tokenList),
    url(r'^tokenscreateuser/$', csrf_exempt(views.tokenCreateUser), name='tokenCreateUser'),
    url(r'^tokensadddoctor/$', csrf_exempt(views.tokenAddDoctor), name='tokenAddDoctor'),
    url(r'^tokensrelatedoctor/$', csrf_exempt(views.tokenRelateDoctor), name='tokenRelateDoctor'),
]