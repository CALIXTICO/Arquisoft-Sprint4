from .models import Measurement
from django.shortcuts import render, redirect
from django.contrib import messages
from django.http import HttpResponse
from django.http import JsonResponse
from django.urls import reverse
from django.conf import settings
import requests
import json

def tokenList(request):
    queryset = Measurement.objects.all()
    context = list(queryset.values('id', 'token', 'nombre', 'apellido', 'rol'))
    return JsonResponse(context, safe=False)

def autorizarDoctor(token):
    url = settings.PATH_VAR
    headers = {"Accept": "application/json", "Content-Type": "application/json"}
    post_data = {"token": token}
    try:
        r = requests.post(url, json=post_data, headers=headers)
        if r.status_code == 200:  
            return 200
        else:
            return 400
    except requests.RequestException as e:
        print(f"Error making POST request: {e}")
    return 0

def tokenAddDoctor(request):
    if request.method == 'POST':
        data = request.body.decode('utf-8')
        data_json = json.loads(data)
        token = data_json.get('token', '')
        if token:
            try:
                usuario = Measurement.objects.get(token=token)
                if usuario.rol == "Administrativo":
                    measurement = Measurement()
                    measurement.nombre = data_json['nombre']
                    measurement.apellido = data_json['apellido']
                    measurement.rol = data_json['rol']
                    measurement.save()

                    solicitud = autorizarDoctor(measurement.token)

                    context = {'nombre': measurement.nombre, 'apellido': measurement.apellido, 'rol': measurement.rol, 'token':measurement.token, 'codDoctor':solicitud}
                    return JsonResponse(context, status=201)
                else:
                    return JsonResponse({'error': 'El usuario no esta autorizado'}, status=404)
            except Measurement.DoesNotExist:
                return JsonResponse({'error': 'El usuario no exite'}, status=404)
        else:
            return JsonResponse({'error': 'No se ingreso token.'}, status=400)
        
def tokenCreateUser(request):
    if request.method == 'POST':
        data = request.body.decode('utf-8')
        data_json = json.loads(data)
        measurement = Measurement()
        measurement.nombre = data_json['nombre']
        measurement.apellido = data_json['apellido']
        measurement.rol = data_json['rol']
        measurement.save()
        context = {'nombre': measurement.nombre, 'apellido': measurement.apellido, 'rol': measurement.rol, 'token':measurement.token}
        return JsonResponse(context, status=201)

def tokenRelateDoctor(request):
    if request.method == 'POST':
        data = request.body.decode('utf-8')
        data_json = json.loads(data)
        token1 = data_json.get('token1', '')
        if token1:
            try:
                usuario = Measurement.objects.get(token=token1)
                if usuario.rol == "Administrativo":
                    try:
                        token2 = data_json.get('token2', '')
                        usuario2 = Measurement.objects.get(token=token2)
                    
                        solicitud = autorizarDoctor(token2)

                        context = {'nombre': usuario2.nombre, 'apellido': usuario2.apellido, 'rol': usuario2.rol, 'token':usuario2.token, 'codDoctor':solicitud}
                        return JsonResponse(context, status=200)
                    
                    except Measurement.DoesNotExist:
                        return JsonResponse({'error': 'El usuario2 no exite'}, status=404)
                else:
                    return JsonResponse({'error': 'El usuario no esta autorizado'}, status=404)
            except Measurement.DoesNotExist:
                return JsonResponse({'error': 'El usuario administrador no exite'}, status=404)
        else:
            return JsonResponse({'error': 'No se ingreso token.'}, status=400)

