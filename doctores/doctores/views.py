from .models import Doctor, Token
from django.shortcuts import render, redirect
from django.contrib import messages
from django.http import HttpResponse
from django.urls import reverse
from django.http import JsonResponse
import json

def DoctorList(request):
    queryset = Doctor.objects.all()
    context = list(queryset.values('id', 'nombre', 'especialidad', 'cuentaBancaria'))
    return JsonResponse(context, safe=False)

def DoctorCreate(request):
    if request.method == 'POST':
        data = request.body.decode('utf-8')
        data_json = json.loads(data)
        if check_token(data_json) == True:
            doctor = Doctor()
            doctor.id = data_json["id"]
            doctor.nombre = data_json["nombre"]
            doctor.especialidad = data_json["especialidad"]
            doctor.cuentaBancaria = data_json["cuentaBancaria"]
            doctor.save()
            return HttpResponse("successfully created doctor")
        else: 
            return HttpResponse("usuario no autorizado para crear doctor")

def TokenCreate(request):
    if request.method == 'POST':
        data = request.body.decode('utf-8')
        data_json = json.loads(data)
        token = Token()
        token.token = data_json["token"]
        token.save()
        return HttpResponse("successfully created token")

def check_token(data):
    tokens = Token.objects.all()
    for token in tokens:
        if data["token"] == token.token:
            return True
    return False
